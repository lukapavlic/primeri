package si.um.feri.napredneniti;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Potrosnik implements Runnable {

    public Potrosnik(Vrecka v) {
        vrecka=v;
    }

    private Vrecka vrecka;
    
    private Random rand=new Random();
    
    private boolean ustaviMe=false;
    
    public void ustavi() {
        ustaviMe=true;
    }
    
    @Override
    public void run() {
        while(!ustaviMe) {
            try {
                vrecka.vzamiZvezdico();
                Thread.sleep(rand.nextInt(100)+100);
            } catch (InterruptedException ex) {
            }
        }
    }

}
