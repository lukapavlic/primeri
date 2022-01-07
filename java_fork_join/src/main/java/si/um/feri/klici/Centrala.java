package si.um.feri.klici;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import si.um.feri.klici.vao.Klic;
import si.um.feri.klici.vao.Narocnik;

public class Centrala {
	
	private List<Klic> klici=new ArrayList<>();

	public Klic poklici(Narocnik n1, String n2, Calendar od, long trajanje) {
		Klic k = new Klic();
		k.setKlicalec(n1);
		k.setCiljnaStevilka(n2);
		k.setAparat("TELEFON");
		k.setTrajanjeSekund(trajanje);
		k.setZacetek(od);

		klici.add(k);
		
		return k;
	}
	
	public List<Klic> vsiKlici() {
		return klici;
	}

}
