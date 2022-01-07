package si.unimb.lisa.prodajalna.test.main;

import si.unimb.lisa.prodajalna.Kupec;

public class KupecTest {

	public static void main(String[] args) {
		String ret=testirajRazred();
		System.out.println((ret==null)?"testirajRazred : brez napak":ret);
	}

	private static String testirajRazred() {
		Kupec k = new Kupec("And1", "Andrej");

		if (!k.getIme().equals("Andrej")) return "Ime je napacno.";
		if (!k.getKoda().equals("And1")) return "Koda je napacna.";
		if (k.getNakupi().size() != 0) return "Nakupi so napacni.";
		return null;
	}	
	

}
