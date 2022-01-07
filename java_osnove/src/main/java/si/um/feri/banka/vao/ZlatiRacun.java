package si.um.feri.banka.vao;

import si.um.feri.banka.Constants;
import java.math.BigDecimal;

public class ZlatiRacun extends BancniRacun {

    public ZlatiRacun() {
    }

    public ZlatiRacun(String iban) {
        super(iban);
    }

    private double dovoljenLimit=Constants.PRIVZETO_DOVOLJEN_LIMIT_ZLATI_RACUN;

    @Override
    public BigDecimal poloziSredstva(BigDecimal znesek) {
        System.out.println("Hvala za polog. Veselilo nas je poslovati z vami.");
        super.poloziSredstva(znesek);
        return trenutnoStanje;
    }

    @Override
    public void doniraj(String namen, double znesek) {
        System.out.println("Naj bo. Doniram "+znesek+" za "+namen);
        dvigniSredstva(new BigDecimal(znesek),"Donacija: "+namen);
    }

    public double getDovoljenLimit() {
        return dovoljenLimit;
    }

    public void setDovoljenLimit(double dovoljenLimit) {
        this.dovoljenLimit = dovoljenLimit;
    }

    @Override
    public String toString() {
        return "ZlatiRacun{" +
                "dovoljenLimit=" + dovoljenLimit +
                "} -> "+super.toString();
    }

}
