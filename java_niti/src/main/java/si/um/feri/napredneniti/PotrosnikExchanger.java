package si.um.feri.napredneniti;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PotrosnikExchanger extends Potrosnik {

    public PotrosnikExchanger(Vrecka v) {
        super(v);
    }

    public static Exchanger<String> ex=new Exchanger<>();
    
    @Override
    public void run() {
        
        String s="Jaz sem potrošnik";
        System.out.println("POTROŠNIK - bi rad izmenjal:"+s);
        try {
            s=ex.exchange(s);
        } catch (InterruptedException ex) {
            Logger.getLogger(PotrosnikExchanger.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("POTROŠNIK je dobil:"+s);

        super.run();
        
    }

}
