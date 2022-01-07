package si.unimb.lisa.prodajalna;

import java.util.ArrayList;
import java.util.Hashtable;

public class Prodajalna {

	public Prodajalna() {
		kupci = new ArrayList<Kupec>();
		artikli = new ArrayList<Artikel>();
		artiklovNaVoljo = new Hashtable<Artikel, Integer>();
	}

	private Hashtable<Artikel, Integer> artiklovNaVoljo;

	private ArrayList<Kupec> kupci;

	private ArrayList<Artikel> artikli;

	public void dodajKupca(Kupec k) {
		kupci.add(k);
	}

	public void dodajArtikel(Artikel a, int enot) {
		artikli.add(a);
		artiklovNaVoljo.put(a, enot);
	}

	public void kupi(String kodaKupca, String kodaArtikla, double odstotekPopusta) {
		Kupec kp = dobiKupca(kodaKupca);
		Artikel ar = dobiArtikel(kodaArtikla);
		if ((kp == null) || (ar == null)) return;
		new Racun(kp, ar, odstotekPopusta);
		Integer naVoljo = artiklovNaVoljo.get(ar);
		artiklovNaVoljo.put(ar, new Integer(naVoljo.intValue() - 1));
	}

	public Kupec dobiKupca(String koda) {
		for (Kupec k : kupci) 
			if (k.getKoda().equals(koda)) return k;
		return null;
	}

	public Artikel dobiArtikel(String koda) {
		for (Artikel k : artikli)
			if (k.getKoda().equals(koda)) return k;
		return null;
	}

	public int artiklovNaVoljo(String kodaArtikla) {
		Artikel ar = dobiArtikel(kodaArtikla);
		if (ar == null) return 0;
		return artiklovNaVoljo.get(ar).intValue();
	}

}
