package si.unimb.lisa.shop.test.junitOld;

import junit.framework.TestCase;
import si.unimb.lisa.shop.Buyer;

public class BuyerTest extends TestCase {
	
	public void testB() {
		Buyer k = new Buyer("And1", "Andrej");

		try {
			
			
			
		} catch (Exception e) {
			

		}
		
		assertEquals(k.getName(),"Andrej");
		assertEquals(k.getCode(),"And1");
		assertEquals(k.getPurchases().size(),0);
		assertTrue(k.getPurchases().size()==0);
		
		
		
	}

}
