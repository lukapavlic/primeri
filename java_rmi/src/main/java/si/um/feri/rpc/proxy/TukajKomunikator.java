package si.um.feri.rpc.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TukajKomunikator implements Oddaljen {

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

}