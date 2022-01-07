package si.unimb.lisa.prodajalna.test.junitOld;

import junit.framework.TestCase;
import si.unimb.lisa.prodajalna.Artikel;
import si.unimb.lisa.prodajalna.Kupec;
import si.unimb.lisa.prodajalna.Racun;

public class RacunTest extends TestCase {
	
	public void testRacuna() {
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

}
