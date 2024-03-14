package si.um.feri.local.calc;

import java.util.logging.Logger;

public class Calculator implements CalculatorInterface {

	private double history;
	
	private Calculation last;

	Logger log=null;//Logger.getLogger(Calculator.class.toString());
	
	@Override
	public double add(double a, double b) {
		if (log!=null) log.info("Calc -> add");
		history=a+b;
		last=new Calculation(a + " + " + b,a+b);
		return a+b;
	}
	
	@Override
	public double sub(double a, double b) {
		if (log!=null) log.info("Calc -> sub");
		history=a-b;
		last=new Calculation(a + " - " + b,a-b);
		return a-b;
	}
	
	@Override
	public double mul(double a, double b) {
		if (log!=null) log.info("Calc -> mul");
		history=a*b;
		last=new Calculation(a + " * " + b,a*b);
		return a*b;
	}
	
	@Override
	public double div(double a, double b) {
		if (log!=null) log.info("Calc -> div");
		history=a/b;
		last=new Calculation(a + " / " + b,a/b);
		return a/b;
	}
	
	@Override
	public double getHistory() {
		if (log!=null) log.info("Calc -> getHistory");
		return history;
	}
	
	@Override
	public Calculation getLastCalculation() {
		if (log!=null) log.info("Calc -> getLastCalculation");
		return last;
	}
	
}
