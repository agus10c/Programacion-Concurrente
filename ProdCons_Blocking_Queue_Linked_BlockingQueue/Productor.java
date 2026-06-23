package ProdCons_Blocking_Queue_Linked_BlockingQueue;

import Tp5.Ejercicio3.Perro;

import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable{
    private BlockingQueue<Elem> buffer;
    public Productor(BlockingQueue<Elem> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        int i = 1;
        while (true) {
            Elem elem = new Elem("Elem "+i);
            try {
                Thread.sleep(i);
                buffer.put(elem);
                System.out.println("Productor agrega "+elem.getElem()+" al buffer");
                i++;
            } catch (InterruptedException e) {
            }
        }
    }
}
