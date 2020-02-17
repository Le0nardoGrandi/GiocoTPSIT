package projectgioco;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client {
    Socket socket = null;
    String nomeServer ="nomeServer";
    int portaServer = 6789;
    DataInputStream in;
    DataOutputStream out;
    
    public Socket connessioneC(){
        try {
            socket = new Socket("127.0.0.1",2000);
            System.out.println("Indirizzo dell'Host:  " + socket.getLocalSocketAddress());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socket;
    }
    public void comunicazioneC(){
        BufferedReader inDalServer = null;
        try {
            inDalServer = new BufferedReader (new InputStreamReader (socket.getInputStream()));
            String prova = inDalServer.readLine();
             System.out.println(prova);
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