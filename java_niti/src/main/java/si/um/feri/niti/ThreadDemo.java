package si.um.feri.niti;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Izpisovalec i=new Izpisovalec("*",200);
        Thread t = new Thread(i);
        t.start();

        Thread.sleep(7000);

        i.zaustaviNit();
    }
}
