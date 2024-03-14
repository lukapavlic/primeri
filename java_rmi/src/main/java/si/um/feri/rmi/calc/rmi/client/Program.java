package si.um.feri.rmi.calc.rmi.client;

import java.rmi.Naming;
import si.um.feri.rmi.calc.rmi.server.Calculator;
import si.um.feri.rmi.calc.rmi.server.CalculatorImpl;

public class Program {

	public static void main(String[] args) throws Exception {
		
		Calculator c=
				//new CalculatorFactory().createCalculator();
				(Calculator)Naming.lookup("//localhost/calc");
				//new Calculator();
		
		System.out.println(c.add(4, 5));
		
		System.out.println(c.getHistory());
		
		System.out.println(c.getLastCalculation());

/*
		for (int i=0;i<5;i++) {
			System.out.println(c.add(c.getHistory(), 1));
		}
*/

/*
		Calculator remote=(Calculator)Naming.lookup("//localhost/calc");
		Calculator local=new CalculatorImpl();

		long start=System.nanoTime();
		for (int i=0;i<10000;i++) local.add(4,5);
		System.out.println((System.nanoTime()-start)/10000);

		start=System.nanoTime();
		for (int i=0;i<10000;i++) remote.add(4,5);
		System.out.println((System.nanoTime()-start)/10000);
*/

	}
	
}
