package si.um.feri.rpc.proxy;

import java.io.IOException;

public class Tukaj {

    public static void main(String[] args) throws IOException {

        Oddaljen oddaljen;
        oddaljen=new OddaljenImpl();
        //oddaljen=new TukajKomunikator();

        System.out.println(oddaljen.dajMePozdravit("FINISH"));
    }

}