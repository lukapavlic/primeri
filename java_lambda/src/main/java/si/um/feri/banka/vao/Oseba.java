package si.um.feri.banka.vao;

import si.um.feri.banka.Bogat;
import java.io.Serializable;
import java.util.Objects;

public class Oseba extends Bogat implements Serializable {

    public Oseba() {
    }

    public Oseba(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    private int id;

    private String ime;

    private String priimek;

    @Override
    public void doniraj(String namen, double znesek) {
        System.out.println("Ja vešda.... nič neo!");
        if (opazovalec!=null) opazovalec.doniralJe(this);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oseba oseba = (Oseba) o;
        return Objects.equals(ime, oseba.ime) && Objects.equals(priimek, oseba.priimek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, priimek);
    }

    @Override
    public String toString() {
        return "Oseba{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                '}';
    }

}
