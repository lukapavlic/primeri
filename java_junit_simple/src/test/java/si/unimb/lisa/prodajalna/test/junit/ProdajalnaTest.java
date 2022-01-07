package si.unimb.lisa.prodajalna.test.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import si.unimb.lisa.prodajalna.Artikel;
import si.unimb.lisa.prodajalna.Kupec;
import si.unimb.lisa.prodajalna.Prodajalna;

public class ProdajalnaTest {
	
	@Before
	public void setUp() {
		p=new Prodajalna();
    	p.dodajArtikel(new Artikel("0","Kolo",100), 3);
    	p.dodajArtikel(new Artikel("1","Kruh",1.5), 10);
    	p.dodajArtikel(new Artikel("2","Miza",52), 2);
    	
    	p.dodajKupca(new Kupec("0","Luka"));
    	p.dodajKupca(new Kupec("1","Bostjan"));
    	p.dodajKupca(new Kupec("2","Marjan"));
    	p.dodajKupca(new Kupec("3","Marko"));
	}

	private Prodajalna p;
	
	@Test
	public void testProdajalne() {
		System.out.println("ProdajalnaTest.testProdajalne();");
    	
    	
    	assertEquals(p.artiklovNaVoljo("0"),3);
    	assertEquals(p.artiklovNaVoljo("1"),10);
    	assertEquals(p.artiklovNaVoljo("2"),2);
    	assertEquals(p.artiklovNaVoljo("20"),0);
    	
    	p.kupi("0", "0", 10);
    	
    	assertFalse(p.dobiKupca("0").getNakupi().get(0).getCenaBrezPopusta()<100);
    	assertEquals(p.artiklovNaVoljo("0"),2);
	}

}
