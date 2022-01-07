package si.um.feri.banka.dao;

import si.um.feri.banka.vao.BancniRacun;
import java.util.Map;

public interface BancniRacunDao {

    class BancniRacunZeObstajaException extends Exception {}

    class ManjkaIbanException extends Exception {}

    Map<String, BancniRacun> vrniVse();

    BancniRacun najdi(String iban);

    void shrani(BancniRacun br) throws BancniRacunZeObstajaException, ManjkaIbanException;

}
