package si.unimb.lisa.prodajalna.test.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import si.unimb.lisa.prodajalna.Kupec;

public class KupecTest {
	
	@Test
	public void testKupca() {
		Kupec k = new Kupec("And1", "Andrej");

		assertEquals(k.getIme(),"Andrej");
		assertEquals(k.getKoda(),"And1");
		assertEquals(k.getNakupi().size(),0);
	}

}
