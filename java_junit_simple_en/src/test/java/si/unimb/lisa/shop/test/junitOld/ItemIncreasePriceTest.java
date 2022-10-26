package si.unimb.lisa.shop.test.junitOld;

import junit.framework.TestCase;
import si.unimb.lisa.shop.Item;

public class ItemIncreasePriceTest extends TestCase {
	
	public void testIncPrc() {
		Item a = new Item();
		a.setPrice(5);
		a.increasePrice(15);

		assertEquals(a.getPrice(),5.5);
	}

}
