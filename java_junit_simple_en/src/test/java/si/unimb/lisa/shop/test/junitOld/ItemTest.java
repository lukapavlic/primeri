package si.unimb.lisa.shop.test.junitOld;

import junit.framework.TestCase;
import si.unimb.lisa.shop.Item;

public class ItemTest extends TestCase {
	
	public void testItm() {
		Item a = new Item();
		a.setPrice(5);
		a.setName("Item1");
		a.setCode("Art1");

		assertEquals(a.getPrice(),5.0,0.001);
		assertEquals(a.getName(),"Item1");
		assertEquals(a.getCode(),"Art1");
	}

}
