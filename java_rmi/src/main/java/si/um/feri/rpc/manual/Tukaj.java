package si.um.feri.rpc.manual;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Tukaj {

    public static void main(String[] args) throws IOException {
        System.out.println(new Oddaljen().dajMePozdravit("geek"));
//        System.out.println(new Tukaj().dajMePozdravit("FINISH"));
    }

    /*
    static int PORT=8888;
    static String HOST="127.0.0.1";

    public String dajMePozdravit(String takole) throws IOException {
        Socket soc=new Socket(HOST,PORT);
        BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
        PrintWriter pw=new PrintWriter(soc.getOutputStream(),true);

        pw.println(takole);
        String ret=br.readLine();

        pw.close();
        br.close();
        soc.close();

        return ret;
    }
    */

}