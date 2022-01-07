package si.um.feri.rmi.staranje.rmi;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) throws Exception {
		
		Oseba peterKlepec=new Oseba("Peter Klepec", 10);
		System.out.println(peterKlepec);
		new LajfFactory().createLajf().postaraj(peterKlepec);
		System.out.println(peterKlepec);
		
	}
	
	
}
