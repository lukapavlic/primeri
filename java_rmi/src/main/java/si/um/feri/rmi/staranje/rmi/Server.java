package si.um.feri.rmi.staranje.rmi;

import java.rmi.Naming;

public class Server {

	public static void main(String[] args) throws Exception {
		Lajf c=new LajfImpl();
		Naming.bind("//localhost/lajf", c);
	}
	
}
