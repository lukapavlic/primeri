package si.um.feri.klici.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;
import si.um.feri.klici.vao.Klic;

public class DolgiKliciAction extends RecursiveAction {

	private static Logger logger = Logger.getAnonymousLogger();

	public DolgiKliciAction(List<Klic> klici) {
		this.klici=klici;
	}
	
	List<Klic> klici;
	
	@Override
	protected void compute() {
		int l=klici.size();
		if (l > 1000) {
			List<DolgiKliciAction> akcije = new ArrayList<>();
			
			akcije.add(new DolgiKliciAction(klici.subList(0, l/2)));
			akcije.add(new DolgiKliciAction(klici.subList(l/2 + 1, l)));
			
			ForkJoinTask.invokeAll(akcije);
			
		} else {
			
			for (Klic k : klici) {
				if (k.getTrajanjeSekund()>120_000)
					System.out.println(k);
			}
			
		}
	}
	
}
