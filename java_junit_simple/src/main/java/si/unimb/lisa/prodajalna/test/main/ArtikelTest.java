package si.unimb.lisa.prodajalna.test.main;

import si.unimb.lisa.prodajalna.Artikel;

public class ArtikelTest {

	public static void main(String[] args) {
		String ret=testirajRazred();
		System.out.println((ret==null)?"testirajRazred : brez napak":ret);
		ret=testirajMetodoPodrazitev();
		System.out.println((ret==null)?"testirajMetodoPodrazitev : brez napak":ret);
	}
	
	private static String testirajRazred() {
		Artikel a = new Artikel();
		a.setCena(5);
		a.setIme("Artikel1");
		a.setKoda("Art1");

		if (a.getCena() != 5) return "Cena je napacna";
		if (!a.getIme().equals("Artikel1")) return "Ime je napacno";
		if (!a.getKoda().equals("Art1")) return "Koda je napacna";
		return null;
	}

	private static String testirajMetodoPodrazitev() {
		Artikel a = new Artikel();
		a.setCena(5);
		a.podrazitev(10);

		if (a.getCena() != 5.5) return "Cena po podrazitvi je napacna";
		return null;
	}
	
}
