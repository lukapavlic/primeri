package si.um.feri.napredneniti;

public class Stevec {
    
    private long st=0;
    
    public long getSt(){
        return st;
    }
    
    public synchronized void povecajZaEna() {
        long rez = st;
        rez = rez + 1;
        st = rez;
    }

    public synchronized void reset() {
        st=0;
    }

    public static void main(String[] args) throws Exception{
        Stevec s=new Stevec();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<300;i++)
                    s.povecajZaEna();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1=new Thread(r); t1.start();
        Thread t2=new Thread(r); t2.start();
        Thread t3=new Thread(r); t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(s.getSt());

    }

}
