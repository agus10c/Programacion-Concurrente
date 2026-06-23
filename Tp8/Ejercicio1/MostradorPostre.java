package Tp8.Ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MostradorPostre {
    private int cantDisponible;
    private final Lock mostradorDisponible= new ReentrantLock(true);
    private final Condition esperarMostradorPostre;
    public MostradorPostre() {
        this.cantDisponible = 3;
        esperarMostradorPostre = mostradorDisponible.newCondition();
    }
    public void buscarPostre() throws InterruptedException {
        mostradorDisponible.lock();
        while (cantDisponible == 0) {
            System.out.println(Thread.currentThread().getName() + " espera para el mostrador de postre");
            esperarMostradorPostre.await();
        }
        this.cantDisponible--;
        System.out.println(Thread.currentThread().getName()+" sirviendose postre (en mostrador de Postre: "+(3-cantDisponible)+")");
        mostradorDisponible.unlock();
        Thread.sleep(2000);
        mostradorDisponible.lock();
        this.cantDisponible++;
        System.out.println(Thread.currentThread().getName()+" termina de servir su postre (en mostrador de Postre: "+(3-cantDisponible)+")");
        esperarMostradorPostre.signal();
        mostradorDisponible.unlock();
    }
}
