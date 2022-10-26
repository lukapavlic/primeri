package si.unimb.lisa.shop.test.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import si.unimb.lisa.shop.Buyer;

public class BuyerTest {
	
	@Test
	public void testBuyer() {
		Buyer k = new Buyer("And1", "Andrej");

		assertEquals(k.getName(),"Andrej");
		assertEquals(k.getCode(),"And1");
		assertEquals(k.getPurchases().size(),0);
	}

}
