package si.unimb.lisa.shop;

import java.util.GregorianCalendar;

public class Receipt {
	
	public Receipt(Buyer k, Item a, double p) {
		buyer = k;
		item = a;
		discount = p;
		purchase = new GregorianCalendar();
		fullPrice = a.getPrice();
		k.getPurchases().add(this);
	}

	private Buyer buyer;

	private Item item;

	private double fullPrice;

	private double discount;

	private GregorianCalendar purchase;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(double fullPrice) {
		this.fullPrice = fullPrice;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public GregorianCalendar getPurchase() {
		return purchase;
	}

	public void setPurchase(GregorianCalendar purchase) {
		this.purchase = purchase;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
