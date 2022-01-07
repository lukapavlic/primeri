package si.unimb.lisa.prodajalna;

import java.util.ArrayList;

public class Kupec {
	
	public Kupec(String k, String i) {
		nakupi = new ArrayList<Racun>();
		koda = k;
		ime = i;
	}

	private ArrayList<Racun>nakupi;

	private String ime;

	private String koda;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getKoda() {
		return koda;
	}

	public void setKoda(String koda) {
		this.koda = koda;
	}

	public ArrayList<Racun> getNakupi() {
		return nakupi;
	}

	public void setNakupi(ArrayList<Racun> nakupi) {
		this.nakupi = nakupi;
	}

}
