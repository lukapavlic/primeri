package si.unimb.lisa.prodajalna.test.junitOld.napredno;

import junit.framework.TestCase;
import si.unimb.lisa.prodajalna.Artikel;

public class ArtikelTest extends TestCase {
	
	protected void setUp() throws Exception {
		System.out.println("ArtikelTest.setUp();");
	}

	public void testArtikla() {
		System.out.println("ArtikelTest.testArtikla();");
		Artikel a = new Artikel();
		a.setCena(5);
		a.setIme("Artikel1");
		a.setKoda("Art1");

		assertEquals(a.getCena(),5.0,0.001);
		assertEquals(a.getIme(),"Artikel1");
		assertEquals(a.getKoda(),"Art1");
	}

	public void testPodrazitev() {
		System.out.println("ArtikelTest.testPodrazitev();");
		Artikel a = new Artikel();
		a.setCena(5);
		a.podrazitev(10);

		assertEquals(a.getCena(),5.5);
	}

	protected void tearDown() throws Exception {
		System.out.println("ArtikelTest.tearDown();");
	}

}
