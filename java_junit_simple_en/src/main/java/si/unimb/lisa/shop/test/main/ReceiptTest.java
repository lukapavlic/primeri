package si.unimb.lisa.shop.test.main;

import si.unimb.lisa.shop.Item;
import si.unimb.lisa.shop.Buyer;
import si.unimb.lisa.shop.Receipt;

public class ReceiptTest {

	public static void main(String[] args) {
		String ret=testirajRazred();
		System.out.println((ret==null)?"testirajRazred : brez napak":ret);
	}

    public static String testirajRazred() {
        Buyer k = new Buyer("And1", "Andrej");

        Item a = new Item();
        a.setPrice(5);
        a.setName("Artikel1");
        a.setCode("Art1");

        Receipt r = new Receipt(k, a, 0);

        if (r.getItem().getPrice() != 5) return "Cena artikla je napacna";
        if (!r.getBuyer().getName().equals("Andrej")) return "Ime kupca je napacno";
        if (k.getPurchases().size() != 1 ) return "Stevilo racunov pri kupcu je napacno";
        if (k.getPurchases().get(0) != r) return "Racun ni bil dodan kupcu";
        return null;
    }
	
}
