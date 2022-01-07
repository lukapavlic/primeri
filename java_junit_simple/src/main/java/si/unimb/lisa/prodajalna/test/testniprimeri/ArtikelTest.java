package si.unimb.lisa.prodajalna.test.testniprimeri;

import si.unimb.lisa.prodajalna.Artikel;

public class ArtikelTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
		Artikel a = new Artikel();
		a.setCena(5);
		a.setIme("Artikel1");
		a.setKoda("Art1");

		if (a.getCena() != 5) return "Cena je napacna";
		if (!a.getIme().equals("Artikel1")) return "Ime je napacno";
		if (!a.getKoda().equals("Art1")) return "Koda je napacna";
		return null;
	}

}
