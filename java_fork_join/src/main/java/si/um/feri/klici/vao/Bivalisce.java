package si.um.feri.klici.vao;

import java.io.Serializable;

public class Bivalisce implements Serializable {

	private static final long serialVersionUID = 4742530347611316195L;

	private long id;

	private String vrsta;

	private String ulica;

	private String stevilka;

	private String posta;

	private String drzava;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getStevilka() {
		return stevilka;
	}

	public void setStevilka(String stevilka) {
		this.stevilka = stevilka;
	}

	public String getPosta() {
		return posta;
	}

	public void setPosta(String posta) {
		this.posta = posta;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	@Override
	public String toString() {
		return "Bivalisce [id=" + id + ", vrsta=" + vrsta + ", ulica=" + ulica + ", stevilka=" + stevilka + ", posta="
				+ posta + ", drzava=" + drzava + "]";
	}

}