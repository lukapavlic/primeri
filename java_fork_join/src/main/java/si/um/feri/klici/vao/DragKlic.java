package si.um.feri.klici.vao;

import java.math.BigDecimal;
import si.um.feri.klici.Predolg;

public class DragKlic extends Klic implements Predolg {
	
	private static final long serialVersionUID = -4784096463512675046L;

	public DragKlic() {
		super();
	}
	
	public DragKlic(BigDecimal cenaKlica, BigDecimal cenaNaSekundo) {
		super();
		this.cenaKlica = cenaKlica;
		this.cenaNaSekundo = cenaNaSekundo;
	}

	private BigDecimal cenaKlica;

	private BigDecimal cenaNaSekundo;

	public BigDecimal getCenaKlica() {
		return cenaKlica;
	}

	public void setCenaKlica(BigDecimal cenaKlica) {
		this.cenaKlica = cenaKlica;
	}

	public BigDecimal getCenaNaSekundo() {
		return cenaNaSekundo;
	}

	public void setCenaNaSekundo(BigDecimal cenaNaSekundo) {
		this.cenaNaSekundo = cenaNaSekundo;
	}
	
	@Override
	public void prekiniTakoj() {
		System.out.println("Prekinjam, ker klic traja predolgo");
		koncajKlic();
	}

	@Override
	public String toString() {
		return "DragKlic [cenaKlica=" + cenaKlica + ", cenaNaSekundo=" + cenaNaSekundo + "] "+super.toString();
	}

}
