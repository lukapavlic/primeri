package si.unimb.lisa.shop.test.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import si.unimb.lisa.shop.Item;

public class ItemTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@Before
	public void before() {
		System.out.println("@Before");
	}
	
	@Test(expected=NullPointerException.class)
	public void testItem() throws Exception {
		System.out.println("ItemTest.testItem();");
		Item a = new Item();
		a.setPrice(5);
		a.setName("Artikel1");
		a.setCode("Art1");
		assertEquals(a.getPrice(),5.0,0.001);
		assertEquals(a.getName(),"Artikel1");
		assertEquals(a.getCode(),"Art1");
		a=null;
		a.getPrice();
	}

	@Test
	public void testIncPrice() {
		System.out.println("ItemTest.testIncPrice();");
		Item a = new Item();
		a.setPrice(5);
		a.increasePrice(10);

		assertEquals(a.getPrice(),5.5,0.00001);
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
