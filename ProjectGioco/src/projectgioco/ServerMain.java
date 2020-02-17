package projectgioco;
public class ServerMain {
    public static void main(String[] args) {
       MultiServer tcpServer = new MultiServer();
       tcpServer.start();
    }
}