package projectgioco;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BuonAnno extends Thread {
    public int  n=0;
    private int t=0;
    BuonAnno(int tempo){
        t=tempo;
    }
    @Override
    public void run(){
        for(int c=t;c!=0;c-=1){
                try {
                    if(n==1){
                        this.interrupt();
                        
                        break;
                    }
                    System.out.println(c);
                    sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BuonAnno.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
}