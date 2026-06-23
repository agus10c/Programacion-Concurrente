package ProdCons_ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Elem> buffer = new ConcurrentLinkedQueue<>();
        Thread productor = new Thread(new Productor(buffer));
        Thread consumidor = new Thread(new Consumidor(buffer));
        productor.start();
        consumidor.start();
    }
}
