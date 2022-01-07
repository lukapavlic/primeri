package si.unimb.lisa.prodajalna.test.main;

import si.unimb.lisa.prodajalna.Artikel;
import si.unimb.lisa.prodajalna.Kupec;
import si.unimb.lisa.prodajalna.Prodajalna;

public class ProdajalnaTest {

	public static void main(String[] args) {
		String ret=testirajRazred();
		System.out.println((ret==null)?"testirajRazred : brez napak":ret);
	}
	
    public static String testirajRazred() {
    	Prodajalna p=new Prodajalna();
    	
    	p.dodajArtikel(new Artikel("0","Kolo",100), 3);
    	p.dodajArtikel(new Artikel("1","Kruh",1.5), 10);
    	p.dodajArtikel(new Artikel("2","Miza",52), 2);
    	
    	p.dodajKupca(new Kupec("0","Luka"));
    	p.dodajKupca(new Kupec("1","Bostjan"));
    	p.dodajKupca(new Kupec("2","Marjan"));
    	p.dodajKupca(new Kupec("3","Marko"));
    	
    	if (p.artiklovNaVoljo("0")!=3) return "Koles ni 3";
    	if (p.artiklovNaVoljo("1")!=10) return "Kruha ni 5";
    	if (p.artiklovNaVoljo("2")!=2) return "Mizi nista 2";
    	if (p.artiklovNaVoljo("20")!=0) return "Neznanega artikla ni 0";
    	
    	p.kupi("0", "0", 10);
    	
    	if (p.dobiKupca("0").getNakupi().get(0).getCenaBrezPopusta()<100) return "Cena ni ustrezna";
    	if (p.artiklovNaVoljo("0")!=2) return "Kolesi nista samo 2";
    	
    	return null;
    }

}
