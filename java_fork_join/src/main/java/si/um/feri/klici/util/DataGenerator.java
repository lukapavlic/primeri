package si.um.feri.klici.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class DataGenerator {

	private static final String MOSKA_IMENA = "/imena_moska.txt";
	private static final String ZENSKA_IMENA = "/imena_zenska.txt";
	private static final String PRIIMKI = "/priimki.txt";
	private static final String ULICE = "/ulice.txt";
	private static final String OBCINE = "/obcine.txt";

	private static Random rand = new Random();

	public class CachedDataReader {

		public CachedDataReader(String file) {
			fileName = file;
		}

		private String fileName;
		private List<String> cache = null;

		public List<String> all() {
			if (cache == null) cache = readFile(fileName, false);
			return cache;
		}

		public String single() {
			return all().get(rand.nextInt(all().size()));
		}
	}

	public CachedDataReader moski = new CachedDataReader(MOSKA_IMENA);
	public CachedDataReader zenske = new CachedDataReader(ZENSKA_IMENA);
	public CachedDataReader priimki = new CachedDataReader(PRIIMKI);
	public CachedDataReader ulice = new CachedDataReader(ULICE);
	public CachedDataReader obcine = new CachedDataReader(OBCINE);

	private List<String> readFile(String datoteka, boolean izpisi) {
		Set<String> ret = new TreeSet<>();
		try {
			InputStream inputStream = new DataGenerator().getClass().getResourceAsStream(datoteka);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String s = br.readLine();
			while (s != null) {
				ret.add(s);
				s = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> retAL = new ArrayList<>();
		retAL.addAll(ret);

		if (izpisi) {
			for (String s : ret) {
				try {
					System.out.println(s.charAt(0) + s.substring(1).toLowerCase());
				} catch (Exception e) {
				}
			}
		}
		return retAL;
	}

	public GregorianCalendar generirajDatum(Calendar odDatuma, Calendar doDatuma) {
		return generirajDatum(odDatuma.getTimeInMillis(), doDatuma.getTimeInMillis());
	}

	public GregorianCalendar generirajDatum(long odDatuma, long doDatuma) {
		GregorianCalendar ret = new GregorianCalendar();
		long offset = Math.abs(rand.nextLong() % (doDatuma - odDatuma));
		ret.setTimeInMillis(odDatuma + offset);
		return ret;
	}

	public String hisnaStevilka() {
		return (rand.nextInt(150) + 1) + "";
	}

	public String vrstaNaslova() {
		switch (rand.nextInt(3)) {
		case 0:
			return "Stalno bivališče";
		case 1:
			return "Začasno bivališče";
		}
		return "Služba";
	}

	public static List<String> emaili(String ime, String priimek) {
		List<String> ret = new ArrayList<>();
		switch (rand.nextInt(3)) {
		case 2:
			ret.add(ime + "." + priimek + "@bing.com");
		case 1:
			ret.add(ime + "." + priimek + "@gmail.com");
		}
		return ret;
	}

	private static int zadnjiTelefon = 0;

	public String telefon() {
		int tel = zadnjiTelefon++;
		String ret = "" + tel;
		while (ret.length() < 8)
			ret = "0" + ret;
		return ret;
	}

}
