package si.unimb.lisa.prodajalna.test.junitOld.napredno;

import junit.framework.TestCase;
import si.unimb.lisa.prodajalna.Artikel;
import si.unimb.lisa.prodajalna.Kupec;
import si.unimb.lisa.prodajalna.Racun;

public class RacunTest extends TestCase {
	
	protected void setUp() throws Exception {
		System.out.println("RacunTest.setUp();");
	}

	public void testRacuna() {
		System.out.println("RacunTest.testRacuna();");
        Kupec k = new Kupec("And1", "Andrej");

        Artikel a = new Artikel();
        a.setCena(5);
        a.setIme("Artikel1");
        a.setKoda("Art1");

        Racun r = new Racun(k, a, 0);

        assertEquals(r.getArtikel().getCena(),5.0,0.001);
        assertEquals(r.getKupec().getIme(),"Andrej");
        assertEquals(k.getNakupi().size(),1);
        assertEquals(k.getNakupi().get(0),r);
	}

	protected void tearDown() throws Exception {
		System.out.println("RacunTest.tearDown();");
	}

}
