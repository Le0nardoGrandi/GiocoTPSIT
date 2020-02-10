package projectgioco;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client {
    public Socket connessioneC(){
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",2000);
            System.out.println("Indirizzo dell'Host:  " + socket.getLocalSocketAddress());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socket;
    }
    public void comunicazioneC(Socket socket){
        BufferedReader inDalServer = null;
        try {
            inDalServer = new BufferedReader (new InputStreamReader (socket.getInputStream()));
            DataOutputStream outVersoServer = new DataOutputStream (socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inDalServer.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
