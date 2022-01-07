package si.um.feri.rmi.calc.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

	private static final long serialVersionUID = -8325734978425380619L;

	transient Logger log;//=Logger.getLogger(Calculator.class.toString());

	public CalculatorImpl() throws RemoteException {
	}

	private double history;
	
	private Calculation last;
	
	@Override
	public double add(double a, double b) throws RemoteException {
		if (log!=null) log.info("Calc -> add");
		history=a+b;
		last=new Calculation(a + " + " + b,a+b);
		return a+b;
	}
	
	@Override
	public double sub(double a, double b) throws RemoteException  {
		if (log!=null) log.info("Calc -> sub");
		history=a-b;
		last=new Calculation(a + " - " + b,a-b);
		return a-b;
	}
	
	@Override
	public double mul(double a, double b) throws RemoteException  {
		if (log!=null) log.info("Calc -> mul");
		history=a*b;
		last=new Calculation(a + " * " + b,a*b);
		return a*b;
	}
	
	@Override
	public double div(double a, double b) throws RemoteException  {
		if (log!=null) log.info("Calc -> div");
		history=a/b;
		last=new Calculation(a + " / " + b,a/b);
		return a/b;
	}
	
	@Override
	public double getHistory() throws RemoteException  {
		if (log!=null) log.info("Calc -> history");
		return history;
	}
	
	@Override
	public Calculation getLastCalculation() throws RemoteException  {
		if (log!=null) log.info("Calc -> getLastCalculation");
		return last;
	}
	
}
