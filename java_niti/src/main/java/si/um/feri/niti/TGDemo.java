package si.um.feri.niti;

public class TGDemo {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("IME");
        Thread t = new Thread(tg, new Izpisovalec("*", 200));
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
    }
}
