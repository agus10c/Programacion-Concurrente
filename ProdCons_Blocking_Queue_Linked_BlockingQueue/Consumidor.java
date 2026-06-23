package ProdCons_Blocking_Queue_Linked_BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable{
    private BlockingQueue<Elem> buffer;
    public Consumidor(BlockingQueue<Elem> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(10);
                System.out.println("Consumidor saca "+buffer.take().getElem()+" del buffer");
            }
        }catch(InterruptedException e) {
        }
    }
}
