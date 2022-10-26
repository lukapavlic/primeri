package si.unimb.lisa.shop.test.main;

import si.unimb.lisa.shop.Buyer;

public class BuyerTest {

	public static void main(String[] args) {
		String ret=testirajRazred();
		System.out.println((ret==null)?"testirajRazred : brez napak":ret);
	}

	private static String testirajRazred() {
		Buyer k = new Buyer("And1", "Andrej");

		if (!k.getName().equals("Andrej")) return "Ime je napacno.";
		if (!k.getCode().equals("And1")) return "Koda je napacna.";
		if (k.getPurchases().size() != 0) return "Nakupi so napacni.";
		return null;
	}	
	

}
