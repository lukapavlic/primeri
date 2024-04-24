package si.um.feri;

public class TestMailSender {

    public static void main(String[] args) throws Exception {
        MailSender ms=new MailSender(
                "mail.nekaj.si",
                "465",
                "nekdo@nekaj.si",
                "------");

        ms.send(
                "luka.pvlc@gmail.com",
                "Mail",
                "Kako je kaj na drugi strani?");
    }

}
