package si.unimb.lisa.shop.test.testniprimeri;

import si.unimb.lisa.shop.Item;

public class ArtikelPodrazitevTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
		Item a = new Item();
		a.setPrice(5);
		a.increasePrice(10);

		if (a.getPrice() != 5.5) return "Cena po podrazitvi je napacna";
		return null;
	}

}
