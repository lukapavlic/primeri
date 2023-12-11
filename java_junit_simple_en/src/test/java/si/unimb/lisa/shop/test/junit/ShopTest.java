package si.unimb.lisa.shop.test.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import si.unimb.lisa.shop.Item;
import si.unimb.lisa.shop.Buyer;
import si.unimb.lisa.shop.Shop;

public class ShopTest {
	
	@Before
	public void setUp() {
		p=new Shop();
    	p.addItem(new Item("0","Bicycle",100), 3);
    	p.addItem(new Item("1","Bread",1.5), 10);
    	p.addItem(new Item("2","Table",52), 2);
    	
    	p.addBuyer(new Buyer("0","Luka"));
    	p.addBuyer(new Buyer("1","Bostjan"));
    	p.addBuyer(new Buyer("2","Marjan"));
    	p.addBuyer(new Buyer("3","Marko"));
	}

	private Shop p;
	
	@Test
	public void testShp() {
		System.out.println("ShopTest.testShp();");
    	
    	
    	assertEquals(p.itemsAvailable("0"),30);
    	assertEquals(p.itemsAvailable("1"),10);
    	assertEquals(p.itemsAvailable("2"),2);
    	assertEquals(p.itemsAvailable("20"),0);
    	
    	p.buy("0", "0", 10);
    	
    	assertFalse(p.findBuyer("0").getPurchases().get(0).getFullPrice()<100);
    	assertEquals(p.itemsAvailable("0"),2);
	}

}
