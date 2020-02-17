package projectgioco;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server extends Thread{
    ServerSocket server =null;
    String stringaRicevuta=null;
    String stringaModifica=null;
    Socket socket= null;
    
    public Server (Socket socket){
        this.socket=socket;
    }
    
    
    @Override
    public void run(){
        try{
            comunicazioneS();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
    
    
    public ServerSocket  connessioneS(){
        try {
            BuonAnno bn= new BuonAnno(5);
            ServerSocket server=new ServerSocket(2000);
            server.setSoTimeout(5000);
            bn.start();
            System.out.println("In attesa di connessioni!");
            socket=server.accept();
            bn.n=1;
            System.out.println("Connessione stabilita!");
            System.out.println("Indirizzo del Server:  " + socket.getLocalSocketAddress());
            return server;
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
            for(;;){
                stringaRicevuta = inDalClient.readLine();
                if(stringaRicevuta == null || stringaRicevuta.equals("FINE")){
                    outVersoClient.writeBytes(stringaRicevuta+" (=>server in chiusura...)"+ '\n');
                    System.out.println("Echo sul server in chiusura :"+ stringaRicevuta);
                    break;
                }
                else{
                    outVersoClient.writeBytes(stringaRicevuta+" (ricevuta e ritrasmessa)" + '\n');
                    System.out.println("6 Echo sul server :"+ stringaRicevuta);
                }
            }
            outVersoClient.close();
            inDalClient.close();
            System.out.println("9 Chiusura socket"+ socket);
            socket.close();
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