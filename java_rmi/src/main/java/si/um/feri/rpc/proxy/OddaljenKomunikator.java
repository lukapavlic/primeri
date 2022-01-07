package si.um.feri.rpc.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class OddaljenKomunikator {

    static Logger log=Logger.getLogger(OddaljenKomunikator.class.toString());
    static int PORT=8888;

    static OddaljenImpl oddaljen=new OddaljenImpl();

    public static void main(String[] args) throws Exception {
        log.info("Čakam, da me kdo pokliče; port:"+PORT);

        ServerSocket serverSocket = new ServerSocket(PORT);

        boolean finish=false;
        while (!finish) {
            Socket socket = serverSocket.accept();
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);

            String s=br.readLine();
            if (s.equals("FINISH")) finish=true;
            pw.println(oddaljen.dajMePozdravit(s));

            br.close();
            pw.close();
            socket.close();
        }

        log.info("FINISH");
        serverSocket.close();
    }

}
