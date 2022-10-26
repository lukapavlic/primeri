package si.unimb.lisa.shop.test.testniprimeri;

import si.unimb.lisa.shop.Buyer;

public class KupecTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
		Buyer k = new Buyer("And1", "Andrej");

		if (!k.getName().equals("Andrej")) return "Ime je napacno.";
		if (!k.getCode().equals("And1")) return "Koda je napacna.";
		if (k.getPurchases().size() != 0) return "Nakupi so napacni.";
		return null;
	}

}
