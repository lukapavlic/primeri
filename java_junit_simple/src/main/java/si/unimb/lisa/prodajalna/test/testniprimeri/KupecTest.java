package si.unimb.lisa.prodajalna.test.testniprimeri;

import si.unimb.lisa.prodajalna.Kupec;

public class KupecTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
		Kupec k = new Kupec("And1", "Andrej");

		if (!k.getIme().equals("Andrej")) return "Ime je napacno.";
		if (!k.getKoda().equals("And1")) return "Koda je napacna.";
		if (k.getNakupi().size() != 0) return "Nakupi so napacni.";
		return null;
	}

}
