package projectgioco;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Tcp {
    public static void main(String[] args) {
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
            } catch (IOException ex) {
            System.err.println("Errore di I/O!");
            }
           finally{
               try {
                   socket.close();
                   System.out.println("Connessione chiusa!");
               } catch (IOException ex) {
                   System.err.println("Errore nella chiusura della connessione!");
               }
           }
    }
}