package si.um.feri.napredneniti;

import java.util.Random;

public class Proizvajalec implements Runnable {

    public Proizvajalec(Vrecka v) {
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
                vrecka.dodajZvezdico();
                Thread.sleep(rand.nextInt(100)+100);
            } catch (InterruptedException ex) {
            }
        }
    }

}
