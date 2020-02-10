package projectgioco;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server {
    public ServerSocket  connessioneS(){
        Socket socket= null;
        try {
            BuonAnno bn= new BuonAnno(5);
            ServerSocket serverSocket=new ServerSocket(2000);
            serverSocket.setSoTimeout(5000);
            bn.start();
            System.out.println("In attesa di connessioni!");
            socket=serverSocket.accept();
            bn.n=1;
            System.out.println("Connessione stabilita!");
            System.out.println("Indirizzo del Server:  " + socket.getLocalSocketAddress());
            return serverSocket;
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void comunicazioneS(Socket socket){
        BufferedReader inDalClient = null;
        try {
            inDalClient = new BufferedReader (new InputStreamReader (socket.getInputStream()));
            DataOutputStream outVersoClient = new DataOutputStream (socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inDalClient.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
