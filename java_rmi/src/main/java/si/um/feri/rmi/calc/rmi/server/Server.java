package si.um.feri.rmi.calc.rmi.server;

import java.rmi.Naming;

public class Server {

	public static void main(String[] args) throws Exception {
		CalculatorImpl c=new CalculatorImpl();
		Naming.bind("//localhost/calc", c);
	}
	
}
