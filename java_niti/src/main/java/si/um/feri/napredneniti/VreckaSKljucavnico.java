package si.um.feri.napredneniti;

import java.util.concurrent.locks.ReentrantLock;

public class VreckaSKljucavnico extends Vrecka {

    public VreckaSKljucavnico() {
        super(4);
        zvezdice="";
    }

    private ReentrantLock lock=new ReentrantLock();
    private String zvezdice;
    
    public void dodajZvezdico() throws InterruptedException {
        lock.lock();
        zvezdice+="*";
        lock.unlock();
        System.out.println(zvezdice);
    }
    
    public void vzamiZvezdico() throws InterruptedException {
        lock.lock();
        if (zvezdice.length()>0) zvezdice=zvezdice.substring(0,zvezdice.length()-1);
        lock.unlock();
        System.out.println(zvezdice);
    }
    
}
