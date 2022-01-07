package si.um.feri.klici.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import si.um.feri.klici.vao.Bivalisce;
import si.um.feri.klici.vao.Narocnik;

public class NarocnikGenerator {

	private static Random rand = new Random();
	
	private DataGenerator dg=new DataGenerator();

	public Bivalisce generirajNaslov() {
		Bivalisce ret = new Bivalisce();
		ret.setVrsta(dg.vrstaNaslova());
		ret.setDrzava("SI");
		ret.setPosta(dg.obcine.single());
		ret.setStevilka(dg.hisnaStevilka());
		ret.setUlica(dg.ulice.single());
		return ret;
	}

	public Narocnik generirajNarocnika() {
		Narocnik ret = new Narocnik();

		if (rand.nextBoolean()) {
			ret.setSpol("M");
			ret.setIme(dg.moski.single());
		} else {
			ret.setSpol("Z");
			ret.setIme(dg.zenske.single());
		}
		ret.setPriimek(dg.priimki.single());

		GregorianCalendar rojstvoOd = new GregorianCalendar();
		rojstvoOd.add(Calendar.YEAR, -95);
		GregorianCalendar rojstvoDo = new GregorianCalendar();
		rojstvoDo.add(Calendar.YEAR, -18);

		ret.setDatumRojstva(dg.generirajDatum(rojstvoOd, rojstvoDo));

		switch (rand.nextInt(3)) {
		case 1:
			ret.getNaslovi().add(generirajNaslov());
		default:
			ret.getNaslovi().add(generirajNaslov());
		}

		for (String s : DataGenerator.emaili(ret.getIme(), ret.getPriimek()))
			ret.getEposte().add(s);

		ret.setTelefonska(dg.telefon());

		return ret;
	}
}
