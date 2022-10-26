package si.um.feri.demo.vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oseba {

    private String ime;

    private String priimek;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Oseba() {
    }

    public Oseba(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Oseba{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", id=" + id +
                '}';
    }

}
