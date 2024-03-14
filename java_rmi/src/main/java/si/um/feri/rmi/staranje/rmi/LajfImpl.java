package si.um.feri.rmi.staranje.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class LajfImpl extends UnicastRemoteObject implements Lajf {

	transient Logger log=Logger.getLogger(LajfImpl.class.toString());

	public LajfImpl() throws RemoteException {
	}
	
	public void postaraj(Oseba o) throws RemoteException {
		if (log!=null) log.info("Staram: "+o);
		o.setStarost(o.getStarost()+1);
		if (log!=null) log.info("Postaran: "+o);
	}
	
}
