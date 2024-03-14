package si.um.feri.local.calc;

public class Program {

	public static void main(String[] args) {
		
		CalculatorInterface c=new Calculator();
		
		System.out.println("4+5="+c.add(4, 5));
		
		System.out.println("history:"+c.getHistory());
		
		System.out.println("last calcultion:"+c.getLastCalculation());
		
		for (int i=0;i<10;i++) {
			System.out.println(c.add(c.getHistory(), 1));
		}
		
	}
	
}
