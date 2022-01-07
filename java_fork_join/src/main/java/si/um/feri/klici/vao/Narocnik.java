package si.um.feri.klici.vao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Narocnik implements Serializable {

	private static final long serialVersionUID = 486771602904544271L;

	private long id;

	private String ime;

	private String priimek;

	private String spol;

	private Calendar datumRojstva;

	private List<Bivalisce> naslovi = new ArrayList<Bivalisce>();

	private List<String> eposte = new ArrayList<String>();

	private String telefonska;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getSpol() {
		return spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public Calendar getDatumRojstva() {
		return datumRojstva;
	}

	public void setDatumRojstva(Calendar datumRojstva) {
		this.datumRojstva = datumRojstva;
	}

	public List<Bivalisce> getNaslovi() {
		return naslovi;
	}

	public void setNaslovi(List<Bivalisce> naslovi) {
		this.naslovi = naslovi;
	}

	public List<String> getEposte() {
		return eposte;
	}

	public void setEposte(List<String> eposte) {
		this.eposte = eposte;
	}

	public String getTelefonska() {
		return telefonska;
	}

	public void setTelefonska(String telefonska) {
		this.telefonska = telefonska;
	}

	@Override
	public String toString() {
		return "Narocnik [id=" + id + ", ime=" + ime + ", priimek=" + priimek + ", spol=" + spol + ", datumRojstva="
				+ datumRojstva + ", naslovi=" + naslovi + ", eposte=" + eposte + ", telefonske=" + telefonska + "]";
	}

}
