package si.um.feri.napredneniti;

import java.util.Random;

public class ProizvajalecExchanger extends Proizvajalec {

    public ProizvajalecExchanger(Vrecka v) {
        super(v);
    }

    @Override
    public void run() {
        String s="Jaz sem proizvajalec";
        System.out.println("PROIZVAJALEC bi rad izmenjal:"+s);
        try {
            s=PotrosnikExchanger.ex.exchange(s);
        } catch (InterruptedException ex) { }
        System.out.println("PROIZVAJALEC je dobil:"+s);
        super.run();
    }

}
