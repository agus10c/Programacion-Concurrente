package ProdCons_Blocking_Queue_Linked_BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Elem> buffer = new LinkedBlockingQueue<>(10);
        Thread productor = new Thread(new Productor(buffer));
        Thread consumidor = new Thread(new Consumidor(buffer));
        productor.start();
        consumidor.start();
    }
}
