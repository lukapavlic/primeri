package si.unimb.lisa.shop.test.main;

import si.unimb.lisa.shop.Item;

public class ItemTest {

	public static void main(String[] args) {
		String ret=testirajRazred();
		System.out.println((ret==null)?"testirajRazred : brez napak":ret);
		ret=testirajMetodoPodrazitev();
		System.out.println((ret==null)?"testirajMetodoPodrazitev : brez napak":ret);
	}
	
	private static String testirajRazred() {
		Item a = new Item();
		a.setPrice(5);
		a.setName("Artikel1");
		a.setCode("Art1");

		if (a.getPrice() != 5) return "Cena je napacna";
		if (!a.getName().equals("Artikel1")) return "Ime je napacno";
		if (!a.getCode().equals("Art1")) return "Koda je napacna";
		return null;
	}

	private static String testirajMetodoPodrazitev() {
		Item a = new Item();
		a.setPrice(5);
		a.increasePrice(10);

		if (a.getPrice() != 5.5) return "Cena po podrazitvi je napacna";
		return null;
	}
	
}
