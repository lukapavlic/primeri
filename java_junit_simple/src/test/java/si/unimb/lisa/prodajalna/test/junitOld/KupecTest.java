package si.unimb.lisa.prodajalna.test.junitOld;

import org.junit.Assert;

import junit.framework.TestCase;
import si.unimb.lisa.prodajalna.Kupec;

public class KupecTest extends TestCase {
	
	public void testKupca() {
		Kupec k = new Kupec("And1", "Andrej");

		try {
			
			
			
		} catch (Exception e) {
			

		}
		
		assertEquals(k.getIme(),"Andrej");
		assertEquals(k.getKoda(),"And1");
		assertEquals(k.getNakupi().size(),0);
		assertTrue(k.getNakupi().size()==0);
		
		
		
	}

}
