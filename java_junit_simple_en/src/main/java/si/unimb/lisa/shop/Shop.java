package si.unimb.lisa.shop;

import java.util.ArrayList;
import java.util.Hashtable;

public class Shop {

	public Shop() {
		buyers = new ArrayList<Buyer>();
		items = new ArrayList<Item>();
		itemsAvailable = new Hashtable<Item, Integer>();
	}

	private Hashtable<Item, Integer> itemsAvailable;

	private ArrayList<Buyer> buyers;

	private ArrayList<Item> items;

	public void addBuyer(Buyer k) {
		buyers.add(k);
	}

	public void addItem(Item a, int units) {
		items.add(a);
		itemsAvailable.put(a, units);
	}

	public void buy(String buyerCode, String itemCode, double discount) {
		Buyer kp = findBuyer(buyerCode);
		Item ar = findItem(itemCode);
		if ((kp == null) || (ar == null)) return;
		new Receipt(kp, ar, discount);
		Integer n = itemsAvailable.get(ar);
		itemsAvailable.put(ar, Integer.valueOf(n.intValue() - 1));
	}

	public Buyer findBuyer(String code) {
		for (Buyer k : buyers)
			if (k.getCode().equals(code)) return k;
		return null;
	}

	public Item findItem(String code) {
		for (Item k : items)
			if (k.getCode().equals(code)) return k;
		return null;
	}

	public int itemsAvailable(String itemCode) {
		Item ar = findItem(itemCode);
		if (ar == null) return 0;
		return itemsAvailable.get(ar).intValue();
	}

}
