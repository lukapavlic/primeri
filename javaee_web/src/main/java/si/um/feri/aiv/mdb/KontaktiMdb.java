//package si.um.feri.aiv.mdb;
//
//import javax.jms.MapMessage;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import si.um.feri.aiv.ejb.Osebe;
//import si.um.feri.aiv.vao.Kontakt;
//import si.um.feri.aiv.vao.Oseba;
//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.EJB;
//import javax.ejb.MessageDriven;
//
//@MessageDriven(activationConfig = {
//		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
//		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
//		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
//public class KontaktiMdb implements MessageListener {
//
//	Logger log=LoggerFactory.getLogger(KontaktiMdb.class);
//
//	@EJB
//	Osebe ejb;
//
//	public void onMessage(Message message) {
//		if (message instanceof MapMessage) {
//			MapMessage mm = (MapMessage) message;
//
//			try {
//
//				String akcija=mm.getString("akcija");
//				String oseba=mm.getString("oseba");
//				String tip=mm.getString("tip");
//				String vsebina=mm.getString("vsebina");
//
//				log.info("akcija:"+akcija + "| oseba:"+oseba + "| tip:"+tip + "| vsebina:"+vsebina);
//
//				if ("dodaj_kontakt".equals(akcija)) {
//
//					Oseba o=ejb.najdi(oseba);
//					if (o==null) throw new Exception("Oseba ne obstaja");
//
//					ejb.dodajKontakt(new Kontakt(tip, vsebina), o);
//
//				} else {
//					log.info("Akcija neznana:"+message);
//				}
//
//			} catch (Exception e) {
//				log.error("Napaka:"+e.getMessage(),e);
//			}
//
//		} else {
//			log.info("Prispelo je neznano sporocilo:"+message);
//		}
//	}
//
//}