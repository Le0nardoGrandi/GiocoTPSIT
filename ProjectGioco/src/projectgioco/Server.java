package projectgioco;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server extends Thread{
    Socket socket= null;
    public ServerSocket  connessioneS(){
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
    public void comunicazioneS(){
        BufferedReader inDalClient = null;
        try {
            inDalClient = new BufferedReader (new InputStreamReader (socket.getInputStream()));
            DataOutputStream outVersoClient = new DataOutputStream (socket.getOutputStream());
            outVersoClient.writeBytes("ciao");
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
    
    public Server (Socket socket){
        this.socket=socket;
    }
    
}