package si.unimb.lisa.prodajalna.test.testniprimeri;

import si.unimb.lisa.prodajalna.Artikel;
import si.unimb.lisa.prodajalna.Kupec;
import si.unimb.lisa.prodajalna.Racun;

public class RacunTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
        Kupec k = new Kupec("And1", "Andrej");

        Artikel a = new Artikel();
        a.setCena(5);
        a.setIme("Artikel1");
        a.setKoda("Art1");

        Racun r = new Racun(k, a, 0);

        if (r.getArtikel().getCena() != 5) return "Cena artikla je napa�na";
        if (!r.getKupec().getIme().equals("Andrej")) return "Ime kupca je napa�no";
        if (k.getNakupi().size() != 1 ) return "�tevilo ra�unov pri kupcu je napa�no";
        if (k.getNakupi().get(0) != r) return "Ra�un ni bil dodan kupcu";
        return null;
	}

}
