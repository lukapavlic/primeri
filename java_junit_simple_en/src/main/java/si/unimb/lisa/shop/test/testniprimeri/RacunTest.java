package si.unimb.lisa.shop.test.testniprimeri;

import si.unimb.lisa.shop.Item;
import si.unimb.lisa.shop.Buyer;
import si.unimb.lisa.shop.Receipt;

public class RacunTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
        Buyer k = new Buyer("And1", "Andrej");

        Item a = new Item();
        a.setPrice(5);
        a.setName("Artikel1");
        a.setCode("Art1");

        Receipt r = new Receipt(k, a, 0);

        if (r.getItem().getPrice() != 5) return "Cena artikla je napa�na";
        if (!r.getBuyer().getName().equals("Andrej")) return "Ime kupca je napa�no";
        if (k.getPurchases().size() != 1 ) return "�tevilo ra�unov pri kupcu je napa�no";
        if (k.getPurchases().get(0) != r) return "Ra�un ni bil dodan kupcu";
        return null;
	}

}
