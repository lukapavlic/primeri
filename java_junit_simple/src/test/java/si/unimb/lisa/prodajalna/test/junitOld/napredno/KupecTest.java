package si.unimb.lisa.prodajalna.test.junitOld.napredno;

import junit.framework.TestCase;
import si.unimb.lisa.prodajalna.Kupec;

public class KupecTest extends TestCase {
	
	protected void setUp() throws Exception {
		System.out.println("KupecTest.setUp();");
	}

	public void testKupca() {
		System.out.println("KupecTest.testKupca();");
		Kupec k = new Kupec("And1", "Andrej");

		assertEquals(k.getIme(),"Andrej");
		assertEquals(k.getKoda(),"And1");
		assertEquals(k.getNakupi().size(),0);
		
		
	}

	protected void tearDown() throws Exception {
		System.out.println("KupecTest.tearDown();");
	}

}
