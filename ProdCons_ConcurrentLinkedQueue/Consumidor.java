package ProdCons_ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumidor implements Runnable{
    private ConcurrentLinkedQueue<Elem> buffer;
    public Consumidor(ConcurrentLinkedQueue<Elem> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(10);
                if (!buffer.isEmpty()) {
                    System.out.println("Consumidor saca "+ buffer.poll().getElem()+" del buffer");
                }
            }
        }catch(InterruptedException e) {
        }
    }
}
