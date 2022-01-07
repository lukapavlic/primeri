package si.um.feri.banka;

import si.um.feri.banka.dao.BancniRacunDao;
import si.um.feri.banka.dao.BancniRacunInMemoryDao;
import si.um.feri.banka.vao.BancniRacun;
import si.um.feri.banka.vao.Oseba;
import si.um.feri.banka.vao.ZlatiRacun;
import java.util.List;
import java.util.Optional;

public class BogatasiDarujejo {

    public static void main(String[] args) {

        BancniRacunDao banka=new BancniRacunInMemoryDao();
        BancniRacun jankovRacun=new BancniRacun("SI56-0000-0000-2222");
        jankovRacun.setLastnik(Optional.of(new Oseba("Janko","Bogataš")));

        List<Bogat> bogati= List.of(
                new Oseba("Martin","Krpan"),
                new BancniRacun("SI56-0000-0000-2222"),
                new ZlatiRacun("SI56-0000-1111-2222")
        );

        bogati.forEach(b->b.setOpazovalec(System.out::println));
        bogati.forEach(b->b.doniraj("Za božička",100d));

    }

}
