package si.um.feri.banka;

import si.um.feri.banka.dao.BancniRacunDBDao;
import si.um.feri.banka.dao.BancniRacunDao;
import si.um.feri.banka.vao.BancniRacun;
import si.um.feri.banka.vao.Oseba;
import si.um.feri.banka.vao.Transakcija;
import si.um.feri.banka.vao.ZlatiRacun;

import java.math.BigDecimal;

public class AplikacijaDB {

    public static void main(String[] args) throws Exception {

        BancniRacunDBDao banka=
                BancniRacunDBDao.getInstance();
                //new BancniRacunInFileDao();
                //new BancniRacunInMemoryDao();

        Oseba janko=new Oseba("Janko","Sladkosned");
        Bogat metka=new Oseba("Metka","Srečnica");
        BancniRacun jankovRacun=new BancniRacun("SI56-0000-0000-2222");
        jankovRacun.setLastnik(janko);

        BancniRacun metkinRacun=new ZlatiRacun("SI56-0000-0000-4444");
        metkinRacun.setLastnik((Oseba)metka);

        banka.shraniOsebo(janko);
        banka.shraniOsebo((Oseba)metka);

        banka.shrani(jankovRacun);
        banka.shrani(metkinRacun);

        banka.shraniTransakcijo(
                new Transakcija(jankovRacun,metkinRacun,new BigDecimal(1000d),"darilo")
        );

        banka.vrniVse().keySet().forEach(br->System.out.println(banka.najdi(br)));

    }

}
