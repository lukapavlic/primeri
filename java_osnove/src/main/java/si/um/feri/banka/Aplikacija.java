package si.um.feri.banka;

import si.um.feri.banka.dao.BancniRacunDBDao;
import si.um.feri.banka.dao.BancniRacunDao;
import si.um.feri.banka.dao.BancniRacunInFileDao;
import si.um.feri.banka.dao.BancniRacunInMemoryDao;
import si.um.feri.banka.vao.BancniRacun;
import si.um.feri.banka.vao.Oseba;
import si.um.feri.banka.vao.ZlatiRacun;

public class Aplikacija {

    public static void main(String[] args) throws Exception {

        BancniRacunDao banka=
                //BancniRacunDBDao.getInstance();
                //new BancniRacunInFileDao();
                new BancniRacunInMemoryDao();

        Oseba janko=new Oseba("Janko","Sladkosned");
        Bogat metka=new Oseba("Metka","Srečnica");
        BancniRacun jankovRacun=new BancniRacun("SI56-0000-0000-2222");
        jankovRacun.setLastnik(janko);

        BancniRacun metkinRacun=new ZlatiRacun("SI56-0000-0000-4444");
        metkinRacun.setLastnik((Oseba)metka);

        banka.shrani(jankovRacun);
        banka.shrani(metkinRacun);

        metkinRacun.doniraj("Za uboge",10_000.0d);

        System.out.println(metkinRacun);
        System.out.println(jankovRacun);

        banka.shrani(metkinRacun);
        banka.shrani(jankovRacun);

        System.out.println("------------");

        banka.vrniVse().keySet().forEach(br->System.out.println(banka.najdi(br)));

    }

}
