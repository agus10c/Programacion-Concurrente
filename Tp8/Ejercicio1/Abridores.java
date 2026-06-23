package Tp8.Ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Abridores {
    private int cantDisponible;
    public Abridores() {
        this.cantDisponible = 10;
    }
    public void usarAbridor() throws InterruptedException {
        synchronized (this) {
            while (cantDisponible == 0) {
                System.out.println(Thread.currentThread().getName()+" esperando Abridor");
                this.wait();
            }
            this.cantDisponible--;
            System.out.println(Thread.currentThread().getName()+" usando Abridor (abridores en uso: "+(10-this.cantDisponible)+")");
        }
        Thread.sleep(1000);
        synchronized (this) {
            this.cantDisponible++;
            System.out.println(Thread.currentThread().getName()+" usando Abridor (abridores en uso: "+(10-this.cantDisponible)+")");
            this.notifyAll();
        }
    }
}
