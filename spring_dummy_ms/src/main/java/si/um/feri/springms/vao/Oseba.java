package si.um.feri.springms.vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oseba {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    private String ime;

    private String priimek;

    public Oseba() {
        this("","","");
    }

    public Oseba(String email, String ime, String priimek) {
        this.email = email;
        this.ime = ime;
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    @Override
    public String toString() {
        return "Oseba{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                '}';
    }

}
