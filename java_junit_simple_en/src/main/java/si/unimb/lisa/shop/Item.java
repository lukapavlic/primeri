package si.unimb.lisa.shop;

public class Item {
	
	public Item() {
		this("","Item",0);
	}

	public Item(String cod, String nme, double prc) {
		name = nme;
		code = cod;
		price = prc;
	}

	public void increasePrice(double percentage) {
		price += price * (percentage / 100.0);
	}

	private double price;

	private String name;

	private String code;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
