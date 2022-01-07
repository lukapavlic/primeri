package si.um.feri.napredneniti;

public class StevecNit implements Runnable {

    public StevecNit(Stevec s, long n) {
        stevec=s;
        doKam=n;
    }

    private Stevec stevec;
    private long doKam;
    
    public void run() {
        for (int i = 0; i < doKam; i++) {
            stevec.povecajZaEna();
            System.out.print(".");
        }
    }

}
