package si.um.feri.klici;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import si.um.feri.klici.dao.NarocnikMemoryDao;
import si.um.feri.klici.util.NarocnikGenerator;
import si.um.feri.klici.vao.Klic;
import si.um.feri.klici.vao.Narocnik;

public class Simulacija {

	public static void main(String[] args) throws Exception {

		NarocnikGenerator ng=new NarocnikGenerator();
		NarocnikMemoryDao dao=new NarocnikMemoryDao();
		
		Centrala centrala=new Centrala();
		
		Random r=new Random();
		List<String> telefonske=new ArrayList<>();
		
		//generiraj 10000 naročnikov
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
		
		//pa še en klic v živo
		String kdo=telefonske.get(r.nextInt(10_000));
		String koga=telefonske.get(r.nextInt(10_000));
		
		new Thread(()->{
			System.out.println(kdo+" kličem "+koga);
			Klic klic=centrala.poklici(dao.najdi(kdo), koga, new GregorianCalendar(), 0);

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			klic.koncajKlic();

			System.out.println("Konec:"+klic);
				
		}).start();
		
	}
	
}
