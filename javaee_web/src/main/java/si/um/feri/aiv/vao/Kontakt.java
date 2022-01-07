package si.um.feri.aiv.vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kontakt {
	
	public Kontakt() {
		this("neznan","Ob obali 3");
	}
	
	public Kontakt(String tip, String naziv) {
		super();
		this.tip = tip;
		this.naziv = naziv;
	}

	private int id;
	
	private String tip;
	
	private String naziv;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
