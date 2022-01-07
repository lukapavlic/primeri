//package si.um.feri.aiv.soap;
//
//import java.util.List;
//import javax.ejb.EJB;
//import javax.jws.WebService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import si.um.feri.aiv.ejb.Osebe;
//import si.um.feri.aiv.vao.Oseba;
//
//@WebService
//public class OsebeWS {
//
//	Logger log=LoggerFactory.getLogger(OsebeWS.class);
//
//	@EJB
//	Osebe ejb;
//
//	public List<Oseba> vrniVseOsebe() {
//		log.info("vrniVseOsebe");
//		return ejb.vrniVse();
//	}
//
//	public void dodajOsebo(Oseba o) {
//		log.info("dodajOsebo("+o+")");
//		ejb.shrani(o);
//	}
//
//}
