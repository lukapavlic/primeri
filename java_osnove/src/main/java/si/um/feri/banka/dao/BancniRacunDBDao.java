package si.um.feri.banka.dao;

import si.um.feri.banka.vao.BancniRacun;
import si.um.feri.banka.vao.Oseba;
import si.um.feri.banka.vao.Transakcija;
import si.um.feri.banka.vao.ZlatiRacun;
import java.sql.*;
import java.util.*;

public class BancniRacunDBDao implements BancniRacunDao {

    static final String DB_URL = "jdbc:h2:mem:testdb";
    static final String USER = "sa";
    static final String PASS = "";

    private Connection conn;

    private static BancniRacunDBDao inst;

    private BancniRacunDBDao() {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            kreirajTabele();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BancniRacunDBDao getInstance() {
        if (inst==null) inst=new BancniRacunDBDao();
        return inst;
    }

    private Connection getConnection() throws SQLException {
        if (conn==null || conn.isClosed())
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
        return conn;
    }

    void kreirajTabele() throws Exception {
        getConnection().createStatement().execute(
                "create table if not exists oseba(" +
                        "id int auto_increment, " +
                        "ime varchar, " +
                        "priimek varchar)");
        getConnection().createStatement().execute(
                "create table if not exists racun(" +
                        "iban varchar, " +
                        "odprt timestamp, " +
                        "lastnik int, " +
                        "stanje decimal, " +
                        "dovoljen_limit decimal, " +
                        "aktiven boolean, " +
                        "zlati boolean)");
        getConnection().createStatement().execute(
                "create table if not exists transakcija(" +
                        "id int auto_increment, " +
                        "izvor varchar, " +
                        "ponor varchar, " +
                        "znesek decimal, " +
                        "cas timestamp, " +
                        "tip int, " +
                        "namen varchar)");
    }

    public Oseba najdiOsebo(int id) {
        System.out.println("DAO: iščem "+id);
        Oseba ret = null;
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from oseba where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ret = new Oseba(rs.getString("ime"), rs.getString("priimek"));
                ret.setId(rs.getInt("id"));
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Oseba shraniOsebo(Oseba o) {
        System.out.println("DAO: shranjujem "+o);
        Connection conn=null;
        try {
            conn=getConnection();
            if (najdiOsebo(o.getId()) != null) {
                PreparedStatement ps = conn.prepareStatement("update oseba set ime=? , priimek=? where id=?");
                ps.setString(1, o.getIme());
                ps.setString(2, o.getPriimek());
                ps.setInt(3, o.getId());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = conn.prepareStatement("insert into oseba(ime , priimek) values (?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, o.getIme());
                ps.setString(2, o.getPriimek());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    o.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public boolean obstajaBancniRacun(String iban) {
        System.out.println("DAO: iščem "+iban);
        boolean ret = false;
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from racun where iban=?");
            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ret=true;
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public BancniRacun najdiBancniRacun(String iban,boolean  sTransakcijami) {
        System.out.println("DAO: iščem "+iban);
        BancniRacun ret = null;
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from racun where iban=?");
            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                if (rs.getBoolean("zlati")) {
                    ret=new ZlatiRacun(iban);
                    ((ZlatiRacun)ret).setDovoljenLimit(rs.getDouble("dovoljen_limit"));
                }
                else ret = new BancniRacun(iban);
                ret.setOdprtOd(rs.getTimestamp("odprt").toLocalDateTime());
                ret.setAktiven(rs.getBoolean("aktiven"));
                ret.setLastnik(najdiOsebo(rs.getInt("lastnik")));
                ret.setTrenutnoStanje(rs.getBigDecimal("stanje"));
                if (sTransakcijami) ret.setTransakcije(vrniVseTransakcije(iban));
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void shraniBancniRacun(BancniRacun br) throws BancniRacunZeObstajaException, ManjkaIbanException {
        System.out.println("DAO: shranjujem "+br);
        if (br.getIban()==null || br.getIban().isEmpty()) throw new ManjkaIbanException();
        if (obstajaBancniRacun(br.getIban())) throw new BancniRacunZeObstajaException();

        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into racun(iban,odprt,lastnik,stanje,dovoljen_limit,aktiven,zlati) values (?,?,?,?,?,?,?)");
            ps.setString(1, br.getIban());
            ps.setTimestamp(2, Timestamp.valueOf(br.getOdprtOd()));
            ps.setInt(3,br.getLastnik().getId());
            ps.setBigDecimal(4,br.getTrenutnoStanje());
            ps.setBoolean(6,br.isAktiven());
            if (br instanceof ZlatiRacun) {
                ps.setBoolean(7,true);
                ps.setDouble(5,((ZlatiRacun)br).getDovoljenLimit());
            } else {
                ps.setBoolean(7,false);
                ps.setDouble(5,-1.0);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shraniTransakcijo(Transakcija t) {
        System.out.println("DAO: shranjujem "+t);
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into transakcija(izvor,ponor,znesek,namen,cas,tip) values (?,?,?,?,?,?)");
            ps.setString(1, t.getIzvor().getIban());
            ps.setString(2, t.getPonor().getIban());
            ps.setBigDecimal(3, t.getZnesek());
            ps.setString(4, t.getNamen());
            ps.setTimestamp(5,Timestamp.valueOf(t.getCasovniZig()));
            ps.setInt(6,t.getTipTransakcije().getValue());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Transakcija> vrniVseTransakcije(String iban) {
        System.out.println("DAO: iščem transakcije "+iban);
        List<Transakcija> ret = new ArrayList<>();
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from transakcija where (izvor=?) or (ponor=?)");
            ps.setString(1, iban);
            ps.setString(2, iban);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transakcija t=new Transakcija(
                        najdiBancniRacun(rs.getString("izvor"),false),
                        najdiBancniRacun(rs.getString("ponor"),false),
                        rs.getBigDecimal("znesek"),
                        rs.getString("namen")
                );
                t.setCasovniZig(rs.getTimestamp("cas").toLocalDateTime());
                int tip=rs.getInt("tip");
                for (Transakcija.TipTransakcije tt : Transakcija.TipTransakcije.values()) {
                    if (tt.getValue()==tip)
                        t.setTipTransakcije(tt);
                }
                ret.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Map<String, BancniRacun> vrniVse() {
        System.out.println("DAO: iščem vse račune");
        Map<String, BancniRacun> ret = new HashMap<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery("select * from racun");
            while (rs.next()) {
                ret.put(rs.getString("iban"),najdiBancniRacun(rs.getString("iban"),true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public BancniRacun najdi(String iban) {
        return najdiBancniRacun(iban,true);
    }

    @Override
    public void shrani(BancniRacun br) throws BancniRacunZeObstajaException, ManjkaIbanException {
        shraniBancniRacun(br);
    }

}
