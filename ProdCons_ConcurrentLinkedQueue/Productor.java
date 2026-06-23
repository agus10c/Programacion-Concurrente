package ProdCons_ConcurrentLinkedQueue;


import java.util.concurrent.ConcurrentLinkedQueue;

public class Productor implements Runnable{
    private ConcurrentLinkedQueue<Elem> buffer;
    public Productor(ConcurrentLinkedQueue<Elem> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        int i = 1;
        while (true) {
            Elem elem = new Elem("Elemento "+i);
            try {
                Thread.sleep(i);
                buffer.add(elem);
                System.out.println("Productor agrega "+elem.getElem()+" al buffer");
                i++;
            } catch (InterruptedException e) {
            }
        }
    }
}
