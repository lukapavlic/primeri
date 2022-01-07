package si.unimb.lisa.prodajalna.test.testniprimeri;

import java.util.ArrayList;

public class IzvajalecTestov {

	public static void main(String[] args) {
		ArrayList<ITestniPrimer> testi=new ArrayList<ITestniPrimer>();
		testi.add(new ArtikelPodrazitevTest());
		testi.add(new ArtikelTest());
		testi.add(new KupecTest());
		testi.add(new RacunTest());
		testi.add(new ProdajalnaTest());

		for (ITestniPrimer primer : testi) {
			try {
				System.out.print(primer.getClass().getName()+"  : ");
				String ret=primer.izvediTest();
				System.out.println((ret==null)?"brez napak":ret);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	
}
