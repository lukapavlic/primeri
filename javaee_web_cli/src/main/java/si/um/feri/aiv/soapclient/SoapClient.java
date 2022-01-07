package si.um.feri.aiv.soapclient;

import si.um.feri.aiv.soapclient.gen.Kontakt;
import si.um.feri.aiv.soapclient.gen.Oseba;
import si.um.feri.aiv.soapclient.gen.OsebeWS;
import si.um.feri.aiv.soapclient.gen.OsebeWSService;

public class SoapClient {

	public static void main(String[] args) {
		
		OsebeWS osebeWS=new OsebeWSService().getOsebeWSPort();
		
		Oseba oseba=new Oseba();
		oseba.setIme("Martin");
		oseba.setPriimek("Krpan");
		oseba.setEmail("martin@gmail.com");
		
		Kontakt k=new Kontakt();
		k.setNaziv("123 123 123");
		k.setTip("Stacionarni telefon");
		oseba.getKontakti().add(k);
		
		osebeWS.dodajOsebo(oseba);
		
	}
	
}
