package si.um.feri.banka.dao;

import si.um.feri.banka.Constants;
import si.um.feri.banka.vao.BancniRacun;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class BancniRacunInFileDao implements BancniRacunDao {

    @Override
    public Map<String, BancniRacun> vrniVse() {
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(Constants.FILE_STORAGE));
            Map<String, BancniRacun> ret =  (Map<String, BancniRacun>)ois.readObject();
            ois.close();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap<String, BancniRacun>();
    }

    private void shrani(Map<String, BancniRacun> br) {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(Constants.FILE_STORAGE));
            oos.writeObject(br);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shrani(BancniRacun br) throws BancniRacunZeObstajaException, ManjkaIbanException{
        if (br.getIban()==null || br.getIban().isEmpty())
            throw new ManjkaIbanException();
        Map<String, BancniRacun> racuni=vrniVse();
        //if (racuni.get(br.getIban())!=null) {
            //throw new BancniRacunZeObstajaException();
        //}
        racuni.put(br.getIban(),br);
        shrani(racuni);
    }

    public BancniRacun najdi(String iban) {
        if (iban==null || iban.isEmpty())
            return null;
        return vrniVse().get(iban);
    }

}
