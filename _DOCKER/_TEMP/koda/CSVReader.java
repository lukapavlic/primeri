package analiza;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CSVReader {

	public static boolean VERBOSE=true;
	
	public static final String OSTALO = "Ostalo";
	public static final String KOMUNIKACIJA = "Komunikacija";
	public static final String IZVEDBA_IN_OCENJEVANJE = "Izvedba in ocenjevanje";
	public static final String PRIPRAVA_IN_VALIDACIJA = "Priprava in validacija";
	public static final String KONCEPTUALNA_ZASNOVA = "Konceptualna zasnova";
	
	static String DEL1="del1_anketa10692-2021-02-10.csv";
	static String DEL2="del2_anketa10699-2021-02-10.csv";
	static String DEL3="del3_anketa10700-2021-02-10.csv";
	static String DEL4="del4_anketa10702-2021-02-10.csv";
	static String DEL5="del5_anketa10706-2021-02-10.csv";

	static String csvString(String orig) {
		//umik =" "
		try {
			if (orig.startsWith("="))
				return orig.substring(2, orig.length()-1);
		} catch (Exception e) {
			return orig;
		}
		return orig;
	}
	
	Map<String,List<String>> beri(String file) throws Exception {
		Map<String,List<String>> ret=new HashMap<String,List<String>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
		String s=br.readLine();
		while (s!=null) {
			String [] array=s.split(";");
			ArrayList<String> list=new ArrayList<String>();
			Collections.addAll(list, array);
			list.remove(0);
			
			if (VERBOSE) {
				if (ret.get(csvString(array[0]))!=null) {
					System.out.println("Branje datoteke - že obstaja: "+array[0]+" - "+ret.get(csvString(array[0])));
					System.out.println("Branje datoteke - menjam z  : "+array[0]+" - "+list);
				}
			}
			
			ret.put(csvString(array[0]),list);
			s=br.readLine();
		}
		br.close();
		return ret;
	}
	
	public static void read(

			Set<String> vzorci,
			Map<String, String> kategorije,
			Set<String> konceptualnaZasnova,
			Set<String> pripravaInValidacija,
			Set<String> izvedbaInOcenjevanje,
			Set<String> komunikacija,
			Set<String> ostalo,

			Set<String> validKeys,
			Set<String> profs,
			Set<String> asists,
			Set<String> profsInAsists,
			Set<String> allAsists,
			Set<String> allProfs,

			Map<String, List<VAOOcenaVzorca>> poAvtorjih,
			List<VAOOcenaVzorca> poAsistentih,
			List<VAOOcenaVzorca> poPredavateljih,

			Map<String, List<VAOOcenaVzorca>> poVzorcih,
			List<VAOOcenaVzorca> poVzorcihKonceptualneZasnove,
			List<VAOOcenaVzorca> poVzorcihPripraveInValidacije,
			List<VAOOcenaVzorca> poVzorcihIzvedbeInOcenjevanja,
			List<VAOOcenaVzorca> poVzorcihKomunikacije,
			List<VAOOcenaVzorca> poVzorcihOstalo,
			
			List<VAOOcenaVzorca> oceneVzorcev,
				
			Map<String,VAOProfil> profili
			
			) throws Exception {
		
		Map<String,List<String>> del1=new CSVReader().beri(DEL1);
		Map<String,List<String>> del2=new CSVReader().beri(DEL2);
		Map<String,List<String>> del3=new CSVReader().beri(DEL3);
		Map<String,List<String>> del4=new CSVReader().beri(DEL4);
		Map<String,List<String>> del5=new CSVReader().beri(DEL5);
		
		List<String> del1Glava=del1.get("﻿Q2");
		List<String> del2Glava=del2.get("﻿Q1");
		List<String> del3Glava=del3.get("﻿Q1");
		List<String> del4Glava=del4.get("﻿Q1");
		List<String> del5Glava=del5.get("﻿Q1");

		List<String> del1GlavaLabele=del1.get("Vaše ime in priimek:");
		List<String> del2GlavaLabele=del2.get("Vaše ime in priimek:");
		List<String> del3GlavaLabele=del3.get("Vaše ime in priimek:");
		List<String> del4GlavaLabele=del4.get("Vaše ime in priimek:");
		List<String> del5GlavaLabele=del5.get("Vaše ime in priimek:");
		
		Set<String> invalidKeys=new HashSet<String>();
		Set<String> allKeys=new TreeSet<String>();
		
		//filtriranje avtorjev - vsi, ki so odgovorili vse --> validKes
		for (String s :del1.keySet()) {
			allKeys.add(s);
			if (!del2.containsKey(s) || !del3.containsKey(s) || !del4.containsKey(s)|| !del5.containsKey(s)) {
				invalidKeys.add(s);
				if (VERBOSE) System.out.println("Ima del1, umikam: "+s);
			}
		}
		for (String s :del2.keySet()) {
			allKeys.add(s);
			if (!del1.containsKey(s) || !del3.containsKey(s) || !del4.containsKey(s)|| !del5.containsKey(s)) {
				invalidKeys.add(s);
				if (VERBOSE) System.out.println("Ima del2, umikam: "+s);
			}
		}
		for (String s :del3.keySet()) {
			allKeys.add(s);
			if (!del1.containsKey(s) || !del2.containsKey(s) || !del4.containsKey(s)|| !del5.containsKey(s)) {
				invalidKeys.add(s);
				if (VERBOSE) System.out.println("Ima del3, umikam: "+s);
			}
		}
		for (String s :del4.keySet()) {
			allKeys.add(s);
			if (!del1.containsKey(s) || !del2.containsKey(s) || !del3.containsKey(s)|| !del5.containsKey(s)) {
				invalidKeys.add(s);
				if (VERBOSE) System.out.println("Ima del4, umikam: "+s);
			}
		}
		for (String s :del5.keySet()) {
			allKeys.add(s);
			if (!del2.containsKey(s) || !del3.containsKey(s) || !del4.containsKey(s)|| !del1.containsKey(s)) {
				invalidKeys.add(s);
				if (VERBOSE) System.out.println("Ima del5, umikam: "+s);
			}
		
		}
		for (String s:allKeys) {
			if (invalidKeys.contains(s)) continue;
			if (s.contains("ime in priimek")) continue;
			validKeys.add(s);
		}
		
		if (VERBOSE) {
			System.out.println("Umaknjeni: ");
			for (String s:invalidKeys) 
				System.out.println(s);
		}
		
		//branje profilov
		for (String s:validKeys) {
			VAOProfil p=new VAOProfil(del1.get(s),del1Glava);
			profili.put(s, p);
			if (p.isAsistentInPredavatelj()) profsInAsists.add(s);
			if (p.isSamoPredavatelj()) profs.add(s);
			if (p.isSamoAsistent()) asists.add(s);
			if (p.isPredavatelj())  allProfs.add(s);
			if (p.isAsistent()) allAsists.add(s);
		}

		////////////////////////////
		// VZORCI
		////////////////////////////
		
		konceptualnaZasnova.add("Odprta knjiga"); 			poVzorcih.put("Odprta knjiga", new ArrayList<VAOOcenaVzorca>());
		konceptualnaZasnova.add("Etapna izvedba");			poVzorcih.put("Etapna izvedba", new ArrayList<VAOOcenaVzorca>());
		konceptualnaZasnova.add("Peteroboj"); 				poVzorcih.put("Peteroboj", new ArrayList<VAOOcenaVzorca>());
		konceptualnaZasnova.add("Nenehno preverjanje"); 	poVzorcih.put("Nenehno preverjanje", new ArrayList<VAOOcenaVzorca>());
		konceptualnaZasnova.add("Ekspertna raven"); 		poVzorcih.put("Ekspertna raven", new ArrayList<VAOOcenaVzorca>());
		konceptualnaZasnova.add("Inovator"); 				poVzorcih.put("Inovator", new ArrayList<VAOOcenaVzorca>());
		konceptualnaZasnova.add("Portfelj dosežkov"); 		poVzorcih.put("Portfelj dosežkov", new ArrayList<VAOOcenaVzorca>());
		konceptualnaZasnova.add("Prijatelj Bloom"); 		poVzorcih.put("Prijatelj Bloom", new ArrayList<VAOOcenaVzorca>());
		
		pripravaInValidacija.add("Strokovni validator");		poVzorcih.put("Strokovni validator", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Statistični validator");		poVzorcih.put("Statistični validator", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Zakriti validator");			poVzorcih.put("Zakriti validator", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Veto kolega");				poVzorcih.put("Veto kolega", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Matematični validator");		poVzorcih.put("Matematični validator", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Večkratnik strokovnjaka");	poVzorcih.put("Večkratnik strokovnjaka", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Testni preizkus");			poVzorcih.put("Testni preizkus", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Primeri vprašanj");			poVzorcih.put("Primeri vprašanj", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Donator vprašanj");			poVzorcih.put("Donator vprašanj", new ArrayList<VAOOcenaVzorca>());
		pripravaInValidacija.add("Variacija na temo");			poVzorcih.put("Variacija na temo", new ArrayList<VAOOcenaVzorca>());

		izvedbaInOcenjevanje.add("Časovna škatla");			poVzorcih.put("Časovna škatla", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Naključno zaporedje");	poVzorcih.put("Naključno zaporedje", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Zamik rezultatov");		poVzorcih.put("Zamik rezultatov", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Jamstvo identitete");		poVzorcih.put("Jamstvo identitete", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Prilagoditev");			poVzorcih.put("Prilagoditev", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Pravičnež");				poVzorcih.put("Pravičnež", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Tabela kriterijev");		poVzorcih.put("Tabela kriterijev", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Pesem evrovizije");		poVzorcih.put("Pesem evrovizije", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Bonus točke");			poVzorcih.put("Bonus točke", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Tretja izmena");			poVzorcih.put("Tretja izmena", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Žrebanje številk");		poVzorcih.put("Žrebanje številk", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Varovalka");				poVzorcih.put("Varovalka", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Samoocenitev");			poVzorcih.put("Samoocenitev", new ArrayList<VAOOcenaVzorca>());
		izvedbaInOcenjevanje.add("Ustni izpit");			poVzorcih.put("Ustni izpit", new ArrayList<VAOOcenaVzorca>());

		komunikacija.add("Predhodna seznanitev");	poVzorcih.put("Predhodna seznanitev", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Pravila Igre");			poVzorcih.put("Pravila Igre", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Časovni opomnik");		poVzorcih.put("Časovni opomnik", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Kontrolni seznam");		poVzorcih.put("Kontrolni seznam", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Klic v sili");			poVzorcih.put("Klic v sili", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Kanal za kolega");		poVzorcih.put("Kanal za kolega", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Akademska poštenost");	poVzorcih.put("Akademska poštenost", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Proaktivni asistent");	poVzorcih.put("Proaktivni asistent", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Požani zid");				poVzorcih.put("Požani zid", new ArrayList<VAOOcenaVzorca>());
		komunikacija.add("Namestnik študent");		poVzorcih.put("Namestnik študent", new ArrayList<VAOOcenaVzorca>());

		ostalo.add("Varni brskalnik");			poVzorcih.put("Varni brskalnik", new ArrayList<VAOOcenaVzorca>());
		ostalo.add("Veliki brat");				poVzorcih.put("Veliki brat", new ArrayList<VAOOcenaVzorca>());
		ostalo.add("24/7 alias dežurstvo");		poVzorcih.put("24/7 alias dežurstvo", new ArrayList<VAOOcenaVzorca>());
		ostalo.add("Polna obremenitev");		poVzorcih.put("Polna obremenitev", new ArrayList<VAOOcenaVzorca>());
		ostalo.add("Certifikacijski center");	poVzorcih.put("Certifikacijski center", new ArrayList<VAOOcenaVzorca>());
		
		vzorci.addAll(konceptualnaZasnova);
		vzorci.addAll(pripravaInValidacija);
		vzorci.addAll(izvedbaInOcenjevanje);
		vzorci.addAll(komunikacija);
		vzorci.addAll(ostalo);
		
		for (String s :konceptualnaZasnova) kategorije.put(s,KONCEPTUALNA_ZASNOVA);
		for (String s :pripravaInValidacija) kategorije.put(s,PRIPRAVA_IN_VALIDACIJA);
		for (String s :izvedbaInOcenjevanje) kategorije.put(s,IZVEDBA_IN_OCENJEVANJE);
		for (String s :komunikacija) kategorije.put(s,KOMUNIKACIJA);
		for (String s :ostalo) kategorije.put(s,OSTALO);
		
		// OCENE VZORCEV
		
		int stevec=1;
		for (String s:validKeys) {
			poAvtorjih.put(s, new ArrayList<VAOOcenaVzorca>());
			
			if (VERBOSE) System.out.println(stevec++ + ". berem odgovore za: "+s);
			
			VAOOcenaVzorca v=new VAOOcenaVzorca(del1.get(s),del1Glava,"Q10a");
			v.avtor=s;
			v.vzorec="Odprta knjiga";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del1.get(s),del1Glava,"Q23a");
			v.avtor=s;
			v.vzorec="Etapna izvedba";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del1.get(s),del1Glava,"Q36a");
			v.avtor=s;
			v.vzorec="Peteroboj";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del1.get(s),del1Glava,"Q49a");
			v.avtor=s;
			v.vzorec="Nenehno preverjanje";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del1.get(s),del1Glava,"Q62a");
			v.avtor=s;
			v.vzorec="Ekspertna raven";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del1.get(s),del1Glava,"Q75a");
			v.avtor=s;
			v.vzorec="Inovator";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del1.get(s),del1Glava,"Q88a");
			v.avtor=s;
			v.vzorec="Portfelj dosežkov";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del1.get(s),del1Glava,"Q101a");
			v.avtor=s;
			v.vzorec="Prijatelj Bloom";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			//////
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q3a");
			v.avtor=s;
			v.vzorec="Strokovni validator";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q16a");
			v.avtor=s;
			v.vzorec="Statistični validator";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q29a");
			v.avtor=s;
			v.vzorec="Zakriti validator";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q42a");
			v.avtor=s;
			v.vzorec="Veto kolega";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q55a");
			v.avtor=s;
			v.vzorec="Matematični validator";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q68a");
			v.avtor=s;
			v.vzorec="Večkratnik strokovnjaka";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q81a");
			v.avtor=s;
			v.vzorec="Testni preizkus";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q94a");
			v.avtor=s;
			v.vzorec="Primeri vprašanj";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q107a");
			v.avtor=s;
			v.vzorec="Donator vprašanj";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			v=new VAOOcenaVzorca(del2.get(s),del2Glava,"Q120a");
			v.avtor=s;
			v.vzorec="Variacija na temo";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
			//////
			
			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q3a");
			v.avtor=s;
			v.vzorec="Časovna škatla";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q16a");
			v.avtor=s;
			v.vzorec="Naključno zaporedje";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q29a");
			v.avtor=s;
			v.vzorec="Zamik rezultatov";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q42a");
			v.avtor=s;
			v.vzorec="Jamstvo identitete";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q55a");
			v.avtor=s;
			v.vzorec="Prilagoditev";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q68a");
			v.avtor=s;
			v.vzorec="Pravičnež";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q81a");
			v.avtor=s;
			v.vzorec="Tabela kriterijev";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q94a");
			v.avtor=s;
			v.vzorec="Pesem evrovizije";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q107a");
			v.avtor=s;
			v.vzorec="Bonus točke";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q120a");
			v.avtor=s;
			v.vzorec="Tretja izmena";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q133a");
			v.avtor=s;
			v.vzorec="Žrebanje številk";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q146a");
			v.avtor=s;
			v.vzorec="Varovalka";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q159a");
			v.avtor=s;
			v.vzorec="Samoocenitev";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del3.get(s),del3Glava,"Q172a");
			v.avtor=s;
			v.vzorec="Ustni izpit";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			///
			
			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q3a");
			v.avtor=s;
			v.vzorec="Predhodna seznanitev";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q16a");
			v.avtor=s;
			v.vzorec="Pravila Igre";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q29a");
			v.avtor=s;
			v.vzorec="Časovni opomnik";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q42a");
			v.avtor=s;
			v.vzorec="Kontrolni seznam";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q55a");
			v.avtor=s;
			v.vzorec="Klic v sili";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q68a");
			v.avtor=s;
			v.vzorec="Kanal za kolega";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q81a");
			v.avtor=s;
			v.vzorec="Akademska poštenost";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q94a");
			v.avtor=s;
			v.vzorec="Proaktivni asistent";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q107a");
			v.avtor=s;
			v.vzorec="Požani zid";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del4.get(s),del4Glava,"Q120a");
			v.avtor=s;
			v.vzorec="Namestnik študent";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			///
			
			v=new VAOOcenaVzorca(del5.get(s),del5Glava,del5GlavaLabele,"Q3a",true);
			v.avtor=s;
			v.vzorec="Varni brskalnik";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del5.get(s),del5Glava,del5GlavaLabele,"Q16a",true);
			v.avtor=s;
			v.vzorec="Veliki brat";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del5.get(s),del5Glava,"Q29a");
			v.avtor=s;
			v.vzorec="24/7 alias dežurstvo";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del5.get(s),del5Glava,"Q42a");
			v.avtor=s;
			v.vzorec="Polna obremenitev";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);

			v=new VAOOcenaVzorca(del5.get(s),del5Glava,"Q55a");
			v.avtor=s;
			v.vzorec="Certifikacijski center";
			poVzorcih.get(v.vzorec).add(v);
			poAvtorjih.get(v.avtor).add(v);
			oceneVzorcev.add(v);
			
		} //for vsi 
		
		///////
		// grupiranje
		///////
		
		for (String avtor : poAvtorjih.keySet()) {
			if (profili.get(avtor).asistent.equals("1"))
				poAsistentih.addAll(poAvtorjih.get(avtor));
			if (profili.get(avtor).predavatelj.equals("1"))
				poPredavateljih.addAll(poAvtorjih.get(avtor));
		}
		
		for (String vz : poVzorcih.keySet()) {
			if (konceptualnaZasnova.contains(vz))
				poVzorcihKonceptualneZasnove.addAll(poVzorcih.get(vz));
			if (pripravaInValidacija.contains(vz))
				poVzorcihPripraveInValidacije.addAll(poVzorcih.get(vz));
			if (izvedbaInOcenjevanje.contains(vz))
				poVzorcihIzvedbeInOcenjevanja.addAll(poVzorcih.get(vz));
			if (komunikacija.contains(vz))
				poVzorcihKomunikacije.addAll(poVzorcih.get(vz));
			if (ostalo.contains(vz))
				poVzorcihOstalo.addAll(poVzorcih.get(vz));
		}
		
	}
	
}
