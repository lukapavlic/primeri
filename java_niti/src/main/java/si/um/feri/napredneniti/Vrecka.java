package si.um.feri.napredneniti;

public class Vrecka {

    public Vrecka(int kapaciteta) {
        zvezdice="";
        this.kapaciteta=kapaciteta;
    }
    
    private int kapaciteta=0;
    private String zvezdice;
    
    public synchronized void dodajZvezdico() throws InterruptedException {
        while (zvezdice.length()==kapaciteta) {
            System.out.println("Čakam na dodajanje.");
            wait();
            System.out.println("Super! Dodajam.");
        }
        zvezdice+="*";
        System.out.println(zvezdice);
        notifyAll();
    }
    
    public synchronized void vzamiZvezdico() throws InterruptedException {
        while (zvezdice.length()==0) {
            System.out.println("Čakam na to, da bo kaj za vzeti.");
            wait();
            System.out.println("Super. Dajmo vzet.");
        } 
        zvezdice=zvezdice.substring(0,zvezdice.length()-1);
        System.out.println(zvezdice);
        notifyAll();
        notify();
    }
    
}
