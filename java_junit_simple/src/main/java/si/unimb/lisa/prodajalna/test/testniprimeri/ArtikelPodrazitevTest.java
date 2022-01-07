package si.unimb.lisa.prodajalna.test.testniprimeri;

import si.unimb.lisa.prodajalna.Artikel;

public class ArtikelPodrazitevTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
		Artikel a = new Artikel();
		a.setCena(5);
		a.podrazitev(10);

		if (a.getCena() != 5.5) return "Cena po podrazitvi je napacna";
		return null;
	}

}
