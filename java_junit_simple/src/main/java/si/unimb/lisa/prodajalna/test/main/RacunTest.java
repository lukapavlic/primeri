package si.unimb.lisa.prodajalna.test.main;

import si.unimb.lisa.prodajalna.Artikel;
import si.unimb.lisa.prodajalna.Kupec;
import si.unimb.lisa.prodajalna.Racun;

public class RacunTest {

	public static void main(String[] args) {
		String ret=testirajRazred();
		System.out.println((ret==null)?"testirajRazred : brez napak":ret);
	}

    public static String testirajRazred() {
        Kupec k = new Kupec("And1", "Andrej");

        Artikel a = new Artikel();
        a.setCena(5);
        a.setIme("Artikel1");
        a.setKoda("Art1");

        Racun r = new Racun(k, a, 0);

        if (r.getArtikel().getCena() != 5) return "Cena artikla je napacna";
        if (!r.getKupec().getIme().equals("Andrej")) return "Ime kupca je napacno";
        if (k.getNakupi().size() != 1 ) return "Stevilo racunov pri kupcu je napacno";
        if (k.getNakupi().get(0) != r) return "Racun ni bil dodan kupcu";
        return null;
    }
	
}
