package si.unimb.lisa.shop.test.testniprimeri;

import si.unimb.lisa.shop.Item;
import si.unimb.lisa.shop.Buyer;
import si.unimb.lisa.shop.Shop;

public class ProdajalnaTest implements ITestniPrimer {
	
	public String izvediTest() throws Exception {
    	Shop p=new Shop();
    	
    	p.addItem(new Item("0","Kolo",100), 3);
    	p.addItem(new Item("1","Kruh",1.5), 10);
    	p.addItem(new Item("2","Miza",52), 2);
    	
    	p.addBuyer(new Buyer("0","Luka"));
    	p.addBuyer(new Buyer("1","Bostjan"));
    	p.addBuyer(new Buyer("2","Marjan"));
    	p.addBuyer(new Buyer("3","Marko"));
    	
    	if (p.itemsAvailable("0")!=3) return "Koles ni 3";
    	if (p.itemsAvailable("1")!=10) return "Kruha ni 5";
    	if (p.itemsAvailable("2")!=2) return "Mizi nista 2";
    	if (p.itemsAvailable("20")!=0) return "Neznanega artikla ni 0";
    	
    	p.buy("0", "0", 10);
    	
    	if (p.findBuyer("0").getPurchases().get(0).getFullPrice()<100) return "Cena ni ustrezna";
    	if (p.itemsAvailable("0")!=2) return "Kolesi nista samo 2";
    	
    	return null;
	}

}
