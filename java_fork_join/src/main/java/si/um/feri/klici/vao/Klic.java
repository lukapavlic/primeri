package si.um.feri.klici.vao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Klic implements Serializable {

	private static final long serialVersionUID = -8469402152961603164L;

	public Klic() {
	}

	public Klic(Narocnik klicalec, String ciljnaStevilka, String aparat) {
		super();
		this.klicalec = klicalec;
		this.ciljnaStevilka = ciljnaStevilka;
		this.aparat = aparat;
		this.zacetek = new GregorianCalendar();
	}
	
	public Klic(Narocnik klicalec, String ciljnaStevilka, String aparat, Calendar zacetek, long trajanjeSekund) {
		super();
		this.klicalec = klicalec;
		this.ciljnaStevilka = ciljnaStevilka;
		this.aparat = aparat;
		this.zacetek = zacetek;
		this.trajanjeSekund = trajanjeSekund;
	}

	private Narocnik klicalec;

	private String ciljnaStevilka;

	private String aparat;

	private Calendar zacetek;

	private long trajanjeSekund;
	
	public void zacniKlic() {
		zacetek=new GregorianCalendar();
	}

	public void koncajKlic() {
		long trajanjeSekundMS=System.currentTimeMillis()-zacetek.getTimeInMillis();
		trajanjeSekund=trajanjeSekundMS % 1000;
	}
	
	public Narocnik getKlicalec() {
		return klicalec;
	}

	public void setKlicalec(Narocnik klicalec) {
		this.klicalec = klicalec;
	}

	public String getCiljnaStevilka() {
		return ciljnaStevilka;
	}

	public void setCiljnaStevilka(String ciljnaStevilka) {
		this.ciljnaStevilka = ciljnaStevilka;
	}

	public String getAparat() {
		return aparat;
	}

	public void setAparat(String aparat) {
		this.aparat = aparat;
	}

	public Calendar getZacetek() {
		return zacetek;
	}

	public void setZacetek(Calendar zacetek) {
		this.zacetek = zacetek;
	}

	public long getTrajanjeSekund() {
		return trajanjeSekund;
	}

	public void setTrajanjeSekund(long trajanjeSekund) {
		this.trajanjeSekund = trajanjeSekund;
	}

	@Override
	public String toString() {
		return "Klic [klicalec=" + klicalec + ", ciljnaStevilka="
				+ ciljnaStevilka + ", aparat=" + aparat + ", zacetek=" + zacetek + ", trajanjeSekund=" + trajanjeSekund
				+ "]";
	}

}
