package si.unimb.lisa.prodajalna.test.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import si.unimb.lisa.prodajalna.Artikel;

public class ArtikelTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@Before
	public void before() {
		System.out.println("@Before");
	}
	
	@Test(expected=NullPointerException.class)
	public void testArtikla() throws Exception {
		System.out.println("ArtikelTest.testArtikla();");
		Artikel a = new Artikel();
		a.setCena(5);
		a.setIme("Artikel1");
		a.setKoda("Art1");
		assertEquals(a.getCena(),5.0,0.001);
		assertEquals(a.getIme(),"Artikel1");
		assertEquals(a.getKoda(),"Art1");
		a=null;
		a.getCena();
	}

	@Test
	public void testPodrazitev() {
		System.out.println("ArtikelTest.testPodrazitev();");
		Artikel a = new Artikel();
		a.setCena(5);
		a.podrazitev(10);

		assertEquals(a.getCena(),5.5,0.00001);
	}

	@After
	public void after() {
		System.out.println("@After");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass");
	}

}
