package si.um.feri.banka.vao;

import si.um.feri.banka.Constants;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transakcija implements Serializable {

    public enum TipTransakcije {
        DVIG(0),POLOG(1),PRENOS_MED_RACUNI(2);
        int value;
        TipTransakcije(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public Transakcija(BancniRacun izvor, BancniRacun ponor, BigDecimal znesek, String namen) {
        this.izvor = izvor;
        this.ponor = ponor;
        this.znesek = znesek;
        this.namen=namen;
    }

    private LocalDateTime casovniZig=LocalDateTime.now();

    private BancniRacun izvor;

    private BancniRacun ponor;

    private BigDecimal znesek;

    private String namen;

    private TipTransakcije tipTransakcije=TipTransakcije.PRENOS_MED_RACUNI;

    public TipTransakcije getTipTransakcije() {
        return tipTransakcije;
    }

    public void setTipTransakcije(TipTransakcije tipTransakcije) {
        this.tipTransakcije = tipTransakcije;
    }

    public String getNamen() {
        return namen;
    }

    public void setNamen(String namen) {
        this.namen = namen;
    }

    public LocalDateTime getCasovniZig() {
        return casovniZig;
    }

    public void setCasovniZig(LocalDateTime casovniZig) {
        this.casovniZig = casovniZig;
    }

    public BancniRacun getIzvor() {
        return izvor;
    }

    public void setIzvor(BancniRacun izvor) {
        this.izvor = izvor;
    }

    public BancniRacun getPonor() {
        return ponor;
    }

    public void setPonor(BancniRacun ponor) {
        this.ponor = ponor;
    }

    public BigDecimal getZnesek() {
        return znesek;
    }

    public void setZnesek(BigDecimal znesek) {
        this.znesek = znesek;
    }

    @Override
    public String toString() {
        return "Transakcija{" +
                "casovniZig=" + ((casovniZig!=null)? Constants.DATE_FORMAT.format(casovniZig):"?")+
                ", izvor=" + ((izvor!=null)?izvor.getIban():"?") +
                ", ponor=" + ((ponor!=null)?ponor.getIban():"?") +
                ", znesek=" + znesek +
                ", namen='" + namen + '\'' +
                '}';
    }

}
