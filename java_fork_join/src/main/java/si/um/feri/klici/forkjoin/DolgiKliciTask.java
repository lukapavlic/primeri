package si.um.feri.klici.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;
import si.um.feri.klici.vao.Klic;

public class DolgiKliciTask extends RecursiveTask<Integer> {

	private static Logger logger = Logger.getAnonymousLogger();

	public DolgiKliciTask(List<Klic> klici) {
		this.klici=klici;
	}
	
	List<Klic> klici;
	
	@Override
	protected Integer compute() {
		int l=klici.size();
		if (l > 1000) {
			
			DolgiKliciTask a=new DolgiKliciTask(klici.subList(0, l/2));
			DolgiKliciTask b=new DolgiKliciTask(klici.subList(l/2 + 1, l));
			a.fork();
			return b.compute()+a.join(); 
			
//			List<DolgiKliciTask> akcije = new ArrayList<>();
//			akcije.add(new DolgiKliciTask(klici.subList(0, l/2)));
//			akcije.add(new DolgiKliciTask(klici.subList(l/2 + 1, l)));
//			return ForkJoinTask.invokeAll(akcije).stream().mapToInt(ForkJoinTask::join).sum();
			
		} else {
			
			int c=0;
			for (Klic k : klici) {
				if (k.getTrajanjeSekund()>120_000)
					c++;
			}
			return c;
			
		}
	}
	
}
