package si.um.feri.niti;

public class Izpisovalec implements Runnable {

    public Izpisovalec(String kaj, int kolikokrat) {
        izpis = kaj;
        ponovitev = kolikokrat;
    }
    
    String izpis;
    int ponovitev;
    boolean ustaviMe = false;

    public void zaustaviNit() {
        ustaviMe = true;
    }

    public void run() {
        for (int i = 0; i < ponovitev; i++) {
            System.out.print(" " + Thread.currentThread().getId() + izpis);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            if (ustaviMe) {
                System.out.println("Ustavili so me!");
                return;
            }
        }
        System.out.println("Kančano.");
    }
}
