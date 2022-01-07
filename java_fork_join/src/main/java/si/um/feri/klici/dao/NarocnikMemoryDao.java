package si.um.feri.klici.dao;

import java.util.HashMap;
import java.util.Map;
import si.um.feri.klici.vao.Narocnik;

public class NarocnikMemoryDao {
	
	public class TelefonskaStevilkaZeObstajaException extends Exception {
		private static final long serialVersionUID = -3323110160476054246L;
	};
	
	public class ManjkaTelefonskaStevilkaException extends Exception {
		private static final long serialVersionUID = -7345935994079180646L;
	};
	
    private Map<String, Narocnik> narocniki=new HashMap<>();

    public Map<String, Narocnik> vrniVse() {
        return narocniki;
    }

    public void shrani(Narocnik na) throws ManjkaTelefonskaStevilkaException, TelefonskaStevilkaZeObstajaException {
        if (na.getTelefonska()==null || na.getTelefonska().isEmpty())
            throw new ManjkaTelefonskaStevilkaException();
        if (narocniki.get(na.getTelefonska())!=null)
            throw new TelefonskaStevilkaZeObstajaException();
        narocniki.put(na.getTelefonska(),na);
    }

    public Narocnik najdi(String tel) {
        if (tel==null || tel.isEmpty())
            return null;
        return narocniki.get(tel);
    }
	
}
