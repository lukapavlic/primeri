package si.um.feri.aiv.jms;

import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

public class JmsClient {

	public static void main(String[] args) throws Exception {
		
		InitialContext ctx = new InitialContext();
		Queue queue = (Queue) ctx.lookup("jms/queue/test");
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		QueueConnection cnn = factory.createQueueConnection("guest","guest");
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		QueueSender sender = session.createSender(queue);

		MapMessage mm=session.createMapMessage();
		mm.setString("akcija", "dodaj_kontakt");
		mm.setString("oseba", "martin@gmail.com");
		mm.setString("tip", "GSM");
		mm.setString("vsebina", "031 031 031");
	
		sender.send(mm);

		session.close();
		
	}
	
}