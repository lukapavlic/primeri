package analiza;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VAOOcenaVzorca {

	VAOOcenaVzorca(List<String> list,List<String> glava, String zacetnoVprasanje) {
		this(list,glava,null, zacetnoVprasanje,false);
	}

	VAOOcenaVzorca(List<String> list,List<String> glava, List<String> glavaLabele, String zacetnoVprasanje, boolean velikiBratVarniBrskalnik) {
		int trenutni=glava.indexOf(zacetnoVprasanje);

//		System.out.println("-------------------------------");
//		if (glavaLabele!=null) {
//			for (int i=trenutni; i<trenutni+25; i++)
//				System.out.println(glavaLabele.get(i));
//		}
		
		if (glavaLabele!=null && !glavaLabele.get(trenutni).equals("Menim da dobro razumem pomen, bistvo, uporabnost vzorca.")) System.out.println("UPS");
		razumem=CSVReader.csvString(list.get(trenutni++));
		jeNov=CSVReader.csvString(list.get(trenutni++));
		
		if (velikiBratVarniBrskalnik) {
			primerenVZivo="-1";
		} else {
			primerenVZivo=CSVReader.csvString(list.get(trenutni++));
		}
		primerenNaDaljavo=CSVReader.csvString(list.get(trenutni++));
		primerenOsnovni=CSVReader.csvString(list.get(trenutni++));
		primerenNapredni=CSVReader.csvString(list.get(trenutni++));
		primerenPrakticni=CSVReader.csvString(list.get(trenutni++));
		uporabenPomnjenje=CSVReader.csvString(list.get(trenutni++));
		uporabenRazumevanje=CSVReader.csvString(list.get(trenutni++));
		uporabenUporaboZnanja=CSVReader.csvString(list.get(trenutni++));
		uporabenKreiranjeNovihZnanj=CSVReader.csvString(list.get(trenutni++));
		primerenZaVelikostSkupine=CSVReader.csvString(list.get(trenutni++));
		semUporabilNaDaljavo=CSVReader.csvString(list.get(trenutni++));
		if (velikiBratVarniBrskalnik) {
			semUporabilVUcilnici="-1";
		} else {
			semUporabilVUcilnici=CSVReader.csvString(list.get(trenutni++));
		}
		jeZaVseMojePredmete=CSVReader.csvString(list.get(trenutni++));
		zahtevaVecDela=CSVReader.csvString(list.get(trenutni++));
		bomUporabilNaDaljavo=CSVReader.csvString(list.get(trenutni++));
		if (velikiBratVarniBrskalnik) {
			bomUporabilVUcilnici="-1";
		} else {
			bomUporabilVUcilnici=CSVReader.csvString(list.get(trenutni++));
		}
		pozitivnoZaObjektivnost=CSVReader.csvString(list.get(trenutni++));
		pozitivnoZaKonsistentnost=CSVReader.csvString(list.get(trenutni++));
		pozitivnoZaMotivacijo=CSVReader.csvString(list.get(trenutni++));
		pozitivnoZaZadovoljstvo=CSVReader.csvString(list.get(trenutni++));
		biPriporocal=CSVReader.csvString(list.get(trenutni++));
		if (glavaLabele!=null && !glavaLabele.get(trenutni).contains("pripravo in izvedbo preverjanja na daljavo")) {
			System.out.println("UPS: "+glavaLabele.get(trenutni));
			System.exit(0);
		}
		jeKljucenZaDaljavo=CSVReader.csvString(list.get(trenutni++));
		antiVzorec=CSVReader.csvString(list.get(trenutni++));
		kategorija=CSVReader.csvString(list.get(trenutni++));
	}
	
	public String avtor;
	public String vzorec;

	public String razumem;
	public String jeNov;
	public String primerenVZivo;
	public String primerenNaDaljavo;
	public String primerenOsnovni;
	public String primerenNapredni;
	public String primerenPrakticni;
	public String uporabenPomnjenje;
	public String uporabenRazumevanje;
	public String uporabenUporaboZnanja;
	public String uporabenKreiranjeNovihZnanj;
	public String primerenZaVelikostSkupine;
	public String semUporabilNaDaljavo;
	public String semUporabilVUcilnici;
	public String jeZaVseMojePredmete;
	public String zahtevaVecDela;
	public String bomUporabilNaDaljavo;
	public String bomUporabilVUcilnici;
	public String pozitivnoZaObjektivnost;
	public String pozitivnoZaKonsistentnost;
	public String pozitivnoZaMotivacijo;
	public String pozitivnoZaZadovoljstvo;
	public String biPriporocal;
	public String jeKljucenZaDaljavo;
	public String antiVzorec;
	public String kategorija;
	
	static public List<Integer> values(List<VAOOcenaVzorca> ocene, String fieldName) throws Exception {
		List<Integer> ret=new ArrayList<Integer>();
		for (VAOOcenaVzorca ov : ocene) {
			int v=Integer.parseInt(ov.getClass().getField(fieldName).get(ov).toString());
			ret.add(v);
			//System.out.println(fieldName+"="+v);
		}
		return ret;
	}
	
	static public List<VAOOcenaVzorca> filterPoAsistentihProfesorjih(List<VAOOcenaVzorca> ocene, Set<String> ljudje) throws Exception {
		List<VAOOcenaVzorca> ret=new ArrayList<VAOOcenaVzorca>();
		for (VAOOcenaVzorca ov : ocene) {
			if (ljudje.contains(ov.avtor))
				ret.add(ov);
		}
		return ret;
	}

	@Override
	public String toString() {
		return "VAOOcenaVzorca [avtor=" + avtor + ", vzorec=" + vzorec + ", razumem=" + razumem + ", jeNov=" + jeNov
				+ ", primerenVZivo=" + primerenVZivo + ", primerenNaDaljavo=" + primerenNaDaljavo + ", primerenOsnovni="
				+ primerenOsnovni + ", primerenNapredni=" + primerenNapredni + ", primerenPrakticni="
				+ primerenPrakticni + ", uporabenPomnjenje=" + uporabenPomnjenje + ", uporabenRazumevanje="
				+ uporabenRazumevanje + ", uporabenUporaboZnanja=" + uporabenUporaboZnanja
				+ ", uporabenKreiranjeNovihZnanj=" + uporabenKreiranjeNovihZnanj + ", primerenZaVelikostSkupine="
				+ primerenZaVelikostSkupine + ", semUporabilNaDaljavo=" + semUporabilNaDaljavo
				+ ", semUporabilVUcilnici=" + semUporabilVUcilnici + ", jeZaVseMojePredmete=" + jeZaVseMojePredmete
				+ ", zahtevaVecDela=" + zahtevaVecDela + ", bomUporabilNaDaljavo=" + bomUporabilNaDaljavo
				+ ", bomUporabilVUcilnici=" + bomUporabilVUcilnici + ", pozitivnoZaObjektivnost="
				+ pozitivnoZaObjektivnost + ", pozitivnoZaKonsistentnost=" + pozitivnoZaKonsistentnost
				+ ", pozitivnoZaMotivacijo=" + pozitivnoZaMotivacijo + ", pozitivnoZaZadovoljstvo="
				+ pozitivnoZaZadovoljstvo + ", biPriporocal=" + biPriporocal + ", jeKljucenZaDaljavo="
				+ jeKljucenZaDaljavo + "]";
	}
	
}
