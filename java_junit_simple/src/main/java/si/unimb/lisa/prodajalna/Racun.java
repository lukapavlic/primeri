package si.unimb.lisa.prodajalna;

import java.util.GregorianCalendar;

public class Racun {
	
	public Racun(Kupec k, Artikel a, double p) {
		kupec = k;
		artikel = a;
		popust = p;
		nakup = new GregorianCalendar();
		cenaBrezPopusta = a.getCena();
		k.getNakupi().add(this);
	}

	private Kupec kupec;

	private Artikel artikel;

	private double cenaBrezPopusta;

	private double popust;

	private GregorianCalendar nakup;

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public double getCenaBrezPopusta() {
		return cenaBrezPopusta;
	}

	public void setCenaBrezPopusta(double cenaBrezPopusta) {
		this.cenaBrezPopusta = cenaBrezPopusta;
	}

	public Kupec getKupec() {
		return kupec;
	}

	public void setKupec(Kupec kupec) {
		this.kupec = kupec;
	}

	public GregorianCalendar getNakup() {
		return nakup;
	}

	public void setNakup(GregorianCalendar nakup) {
		this.nakup = nakup;
	}

	public double getPopust() {
		return popust;
	}

	public void setPopust(double popust) {
		this.popust = popust;
	}
	
}
