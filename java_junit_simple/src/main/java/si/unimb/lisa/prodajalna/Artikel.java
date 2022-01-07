package si.unimb.lisa.prodajalna;

public class Artikel {
	
	public Artikel() {
		this("","Artikel",0);
	}

	public Artikel(String inkoda, String inime, double incena) {
		ime = inime;
		koda = inkoda;
		cena = incena;
	}

	public void podrazitev(double odstotkov) {
		cena += cena * (odstotkov / 100.0);
	}

	private double cena;

	private String ime;

	private String koda;

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

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

}
