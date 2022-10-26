package si.unimb.lisa.shop.test.junitOld;

import junit.framework.TestCase;
import si.unimb.lisa.shop.Item;
import si.unimb.lisa.shop.Buyer;
import si.unimb.lisa.shop.Receipt;

public class ReceiptTest extends TestCase {
	
	public void testRac() {
        Buyer k = new Buyer("And1", "Andrej");

        Item a = new Item();
        a.setPrice(5);
        a.setName("Artikel1");
        a.setCode("Art1");

        Receipt r = new Receipt(k, a, 0);

        assertEquals(r.getItem().getPrice(),5.0,0.001);
        assertEquals(r.getBuyer().getName(),"Andrej");
        assertEquals(k.getPurchases().size(),1);
        assertEquals(k.getPurchases().get(0),r);
	}

}
