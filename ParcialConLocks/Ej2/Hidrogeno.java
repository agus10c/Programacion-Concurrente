package ParcialConLocks.Ej2;

import java.util.Random;

public class Hidrogeno implements Runnable{
    private Recipiente recipinete;
    public Hidrogeno(Recipiente recipinete){
        this.recipinete = recipinete;
    }
    private void vagar() throws InterruptedException {
        Random r = new Random();
        Thread.sleep(r.nextInt(5)+1);
    }
    @Override
    public void run() {
        try {
            this.vagar();
            recipinete.hListo();
            recipinete.hacerAgua();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
