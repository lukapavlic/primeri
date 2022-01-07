package si.um.feri.aiv.ejb;

import java.util.List;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

public interface Osebe {

	Oseba najdi(String email);
	
	Oseba najdi(int id);

	void shrani(Oseba o);
	
	void merge(Oseba o);
	
	Oseba dodajKontakt(Kontakt k,Oseba o);

	List<Oseba> vrniVse();

}