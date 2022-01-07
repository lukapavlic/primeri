package si.unimb.lisa.prodajalna.test.junitOld;

import junit.framework.TestCase;
import si.unimb.lisa.prodajalna.Artikel;

public class ArtikelPodrazitevTest extends TestCase {
	
	public void testPodrazitev() {
		Artikel a = new Artikel();
		a.setCena(5);
		a.podrazitev(15);

		assertEquals(a.getCena(),5.5);
	}

}
