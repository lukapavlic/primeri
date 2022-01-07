package si.um.feri.rmi.staranje.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LajfFactory {

    public Lajf createLajf() throws Exception {
        //return (Lajf) Naming.lookup("//localhost/lajf");
        return new LajfImpl();
    }

}
