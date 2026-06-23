package ParcialConLocks.Ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Recipiente {
    private int oxigenos, hidrogenos, k, cantAgua;
    private Lock hListo= new ReentrantLock();
    private Lock oListo= new ReentrantLock();
    private Lock hacerAgua = new ReentrantLock();
    private Condition esperarAtomos;
    private boolean haciendoAgua;
    public Recipiente(int k) {
        this.k = k;
        this.cantAgua = 0;
        this.haciendoAgua = false;
        this.oxigenos = 0;
        this.hidrogenos = 0;
        this.esperarAtomos = hacerAgua.newCondition();
    }

    public void hListo() throws InterruptedException {
        hListo.lock();
        hidrogenos++;
        System.out.println("+1 hidrogeno, cant hidrogenos: "+hidrogenos);
        hacerAgua.lock();
        esperarAtomos.signal();
        hacerAgua.unlock();
        if(!haciendoAgua) {
            this.hacerAgua();
        }
        hListo.unlock();
    }
    public void oListo() throws InterruptedException {
        oListo.lock();
        oxigenos++;
        System.out.println("+1 oxigeno, cant oxigenos: "+oxigenos);
        hacerAgua.lock();
        esperarAtomos.signal();
        hacerAgua.unlock();
        if(!haciendoAgua) {
            this.hacerAgua();
        }
        oListo.unlock();
    }

    public void hacerAgua() throws InterruptedException {
        hacerAgua.lock();
        if(!haciendoAgua) {
            haciendoAgua = true;
            hListo.lock();
            oListo.lock();
            while(hidrogenos<2 && oxigenos<1) {
                esperarAtomos.await();
            }
            this.oxigenos--;
            this.hidrogenos = hidrogenos-2;
            hListo.unlock();
            oListo.unlock();
            cantAgua++;
            System.out.println("Se hizo agua, cargando recipiente");
            if(cantAgua >= k) {
                cantAgua = 0;
                System.out.println("recipiente lleno, se envasa y se vacia el recipiente");
            }
            haciendoAgua = false;
        }
        hacerAgua.unlock();
    }

}
