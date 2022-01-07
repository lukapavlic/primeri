package si.unimb.lisa.prodajalna.test.junitOld;

import junit.framework.TestCase;
import si.unimb.lisa.prodajalna.Artikel;

public class ArtikelTest extends TestCase {
	
	public void testArtikla() {
		Artikel a = new Artikel();
		a.setCena(5);
		a.setIme("Artikel1");
		a.setKoda("Art1");

		assertEquals(a.getCena(),5.0,0.001);
		assertEquals(a.getIme(),"Artikel1");
		assertEquals(a.getKoda(),"Art1");
	}

}
