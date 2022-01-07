package si.um.feri.local.calc;

public class Calculation {

	public Calculation() {
	}
	
	public Calculation(String calc, double result) {
		this.calc = calc;
		this.result = result;
	}

	private String calc;
	
	private double result;
	
	public String getCalc() {
		return calc;
	}

	public void setCalc(String calc) {
		this.calc = calc;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Calculation{" +
				"calc='" + calc + '\'' +
				", result=" + result +
				'}';
	}

}
