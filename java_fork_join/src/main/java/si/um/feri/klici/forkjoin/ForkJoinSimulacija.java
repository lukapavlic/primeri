package si.um.feri.klici.forkjoin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

import si.um.feri.klici.Centrala;
import si.um.feri.klici.dao.NarocnikMemoryDao;
import si.um.feri.klici.util.NarocnikGenerator;
import si.um.feri.klici.vao.Narocnik;

public class ForkJoinSimulacija {

	public static void main(String[] args) throws Exception {
		
		NarocnikGenerator ng=new NarocnikGenerator();
		NarocnikMemoryDao dao=new NarocnikMemoryDao();
		
		Centrala centrala=new Centrala();
		
		Random r=new Random();
		List<String> telefonske=new ArrayList<>();
		
		//generiraj 10000 narocnikov
		for (int i=0;i<10_000;i++) {
			Narocnik n=ng.generirajNarocnika();
			dao.shrani(n);
			telefonske.add(n.getTelefonska());
		}
		
		//generiraj 50000 klicev v zadnjem letu
		for (int i=0;i<50_000;i++) {
			String kdo=telefonske.get(r.nextInt(10_000));
			String koga=telefonske.get(r.nextInt(10_000));
			Calendar kdaj=new GregorianCalendar();
			kdaj.setTimeInMillis(System.currentTimeMillis()-r.nextLong()%31_000_000_000l);
			centrala.poklici(
				dao.najdi(kdo),
				koga,
				kdaj,
				r.nextLong()%120000+5000
			);
			if (i%1000==0)
				System.out.print(".");
		}
		System.out.println("OK");
		
		ForkJoinPool commonPool = ForkJoinPool.commonPool();

		DolgiKliciAction dka=new DolgiKliciAction(centrala.vsiKlici());
		commonPool.execute(dka);
		System.out.println(dka.join());
		
		DolgiKliciTask dkt=new DolgiKliciTask(centrala.vsiKlici());
		commonPool.execute(dkt);
		System.out.println(dkt.join());
		System.out.println("OK");

	}

}
