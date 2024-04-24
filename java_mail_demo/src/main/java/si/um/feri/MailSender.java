package si.um.feri;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailSender {

    MailSender(String mailServer, String port, String user, String passwd) {
        this.userName=user;
        this.password=passwd;
        this.mailServer=mailServer;
        this.port=port;
    }

    String userName;
    String password;
    String mailServer;
    String port;

    public void send(String to, String title, String content) throws Exception {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", mailServer);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", "true");

        //ssl
        prop.put("mail.smtp.socketFactory.port", port);
        prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        //ttls
        //prop.put("mail.smtp.starttls.enable", "true");

        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };

        System.out.println("Creating session");
        Session session = Session.getInstance(prop, auth);

        System.out.println("Creating message");
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userName));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(userName));
        message.setReplyTo(InternetAddress.parse(userName));
        message.setSubject(title);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(content, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        System.out.println("Sending message");
        Transport.send(message);
    }

}
