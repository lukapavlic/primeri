package si.um.feri.banka.dao;

import si.um.feri.banka.vao.BancniRacun;
import java.util.HashMap;
import java.util.Map;

public class BancniRacunInMemoryDao implements BancniRacunDao {

    private Map<String, BancniRacun> racuni=new HashMap<>();

    @Override
    public Map<String, BancniRacun> vrniVse() {
        return racuni;
    }

    public void shrani(BancniRacun br) throws BancniRacunZeObstajaException, ManjkaIbanException{
        if (br.getIban()==null || br.getIban().isEmpty())
            throw new ManjkaIbanException();
        if (racuni.get(br.getIban())!=null)
            throw new BancniRacunZeObstajaException();

        racuni.put(br.getIban(),br);
    }

    public BancniRacun najdi(String iban) {
        if (iban==null || iban.isEmpty())
            return null;
        return racuni.get(iban);
    }

}
