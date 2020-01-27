package projectgioco;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
             socket = new Socket("127.0.0.1",2000);
             System.out.println("Indirizzo dell'Host:  " + socket.getLocalSocketAddress());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}