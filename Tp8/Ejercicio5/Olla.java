package Tp8.Ejercicio5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Olla {
    private int racion, cantidad;
    private final Lock mutex = new ReentrantLock();
    private final Condition esperaComer;
    private final Condition esperaCocinar;
    private final Condition ultimo;
    private boolean ulti;
    public Olla(int cantRacion) {
        this.racion = cantRacion;
        this.cantidad=cantRacion;
        this.esperaComer = mutex.newCondition();
        this.esperaCocinar = mutex.newCondition();
        this.ultimo = mutex.newCondition();
        this.ulti=true;
    }
    public void comer() throws InterruptedException {
        mutex.lock();
        while (racion == 0) {
            this.esperaCocinar.signal();
            if(ulti) {
                ulti=false;
                ultimo.await();
                esperaComer.signalAll();
            } else {
                esperaComer.await();
            }
        }
        System.out.println("canibal comiendo");
        this.racion--;
        mutex.unlock();
    }
    public void reponerOlla() throws InterruptedException {
        mutex.lock();
        if(this.racion != 0)
        esperaCocinar.await();
        System.out.println("esta cocinando");
        Thread.sleep(2000);
        System.out.println("termino de cocinar");
        this.racion = this.cantidad;
        this.ulti =true;
        this.ultimo.signal();
        mutex.unlock();
    }
}
