package si.um.feri.banka.vao;

import si.um.feri.banka.Bogat;
import si.um.feri.banka.Constants;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class BancniRacun implements Bogat, Serializable {

    public BancniRacun() {
        System.out.println("Odpiramo nov bančni račun.");
        trenutnoStanje=new BigDecimal(0.0d);
        aktiven=true;
    }

    public BancniRacun(String iban) {
        this();
        System.out.println("Odpiramo nov bančni račun z iban:"+iban);
        this.iban=iban;
    }

    private String iban;

    private LocalDateTime odprtOd=LocalDateTime.now();

    private Oseba lastnik;

    protected BigDecimal trenutnoStanje;

    boolean aktiven;

    private List<Transakcija> transakcije=new ArrayList<>();

    public BigDecimal poloziSredstva(BigDecimal znesek) {
        Transakcija t=new Transakcija(null,this,znesek,"Osebni polog");
        transakcije.add(t);
        trenutnoStanje=trenutnoStanje.add(znesek);
        return trenutnoStanje;
    }

    public BigDecimal dvigniSredstva(BigDecimal znesek) {
        return dvigniSredstva(znesek, "Osebni dvig");
    }

    public BigDecimal dvigniSredstva(BigDecimal znesek, String namen) {
        Transakcija t=new Transakcija(this,null,znesek,namen);
        transakcije.add(t);
        trenutnoStanje=trenutnoStanje.subtract(znesek);
        return trenutnoStanje;
    }

    @Override
    public void doniraj(String namen, double znesek) {
        System.out.println("Morda kdaj drugič.");
    }

    public BigDecimal getTrenutnoStanje() {
        return trenutnoStanje;
    }

    public void setTrenutnoStanje(BigDecimal trenutnoStanje) {
        this.trenutnoStanje = trenutnoStanje;
    }

    public List<Transakcija> getTransakcije() {
        return transakcije;
    }

    public void setTransakcije(List<Transakcija> transakcije) {
        this.transakcije = transakcije;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public LocalDateTime getOdprtOd() {
        return odprtOd;
    }

    public void setOdprtOd(LocalDateTime odprtOd) {
        this.odprtOd = odprtOd;
    }

    public Oseba getLastnik() {
        return lastnik;
    }

    public void setLastnik(Oseba lastnik) {
        this.lastnik = lastnik;
    }

    public boolean isAktiven() {
        return aktiven;
    }

    public void setAktiven(boolean aktiven) {
        this.aktiven = aktiven;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("BancniRacun{" +
                "iban='" + iban + '\'' +
                ", odprtOd=" + ((odprtOd!=null)? Constants.DATE_FORMAT.format(odprtOd):"?")+
                ", lastnik=" + lastnik +
                ", trenutnoStanje=" + trenutnoStanje+
                "}");
        for (Iterator i = transakcije.iterator(); i.hasNext();) {
            Transakcija t=(Transakcija)i.next();
            sb.append("\n\t- ");
            sb.append(t.toString());
        }
        return sb.toString();
    }

}
