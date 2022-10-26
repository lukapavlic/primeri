package si.unimb.lisa.shop;

import java.util.ArrayList;

public class Buyer {
	
	public Buyer(String k, String i) {
		purchases = new ArrayList<Receipt>();
		code = k;
		name = i;
	}

	private ArrayList<Receipt> purchases;

	private String name;

	private String code;

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

	public ArrayList<Receipt> getPurchases() {
		return purchases;
	}

	public void setPurchases(ArrayList<Receipt> purchases) {
		this.purchases = purchases;
	}

}
