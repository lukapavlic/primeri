package si.unimb.lisa.shop.test.testniprimeri;

import si.unimb.lisa.shop.Item;

public class ArtikelTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
		Item a = new Item();
		a.setPrice(5);
		a.setName("Artikel1");
		a.setCode("Art1");

		if (a.getPrice() != 5) return "Cena je napacna";
		if (!a.getName().equals("Artikel1")) return "Ime je napacno";
		if (!a.getCode().equals("Art1")) return "Koda je napacna";
		return null;
	}

}
