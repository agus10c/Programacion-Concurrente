package Tp8.Ejercicio1;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MostradorAlmuerzo {
    private int cantDisponible;
    private final Lock mostradorDisponible= new ReentrantLock(true);
    private final Condition esperarMostradorAlmuerzo;
    public MostradorAlmuerzo() {
        this.cantDisponible = 5;
        esperarMostradorAlmuerzo = mostradorDisponible.newCondition();
    }
    private boolean seleccionarGaseosa() {
        Random r = new Random();
        return r.nextBoolean();
    }
    public boolean buscarAlmuerzo() throws InterruptedException {
        mostradorDisponible.lock();
        while (cantDisponible == 0) {
            System.out.println(Thread.currentThread().getName()+" espera para el mostrador de almuerzo");
            esperarMostradorAlmuerzo.await();
        }
        this.cantDisponible--;
        System.out.println(Thread.currentThread().getName()+" sirviendose almuerzo (en mostrador de almuerzo: "+(5-cantDisponible)+")");
        mostradorDisponible.unlock();
        boolean seleccionoGaseosa = this.seleccionarGaseosa();
        if(seleccionoGaseosa) {
            System.out.println(Thread.currentThread().getName()+" escogio tomar gaseosa");
        } else {
            System.out.println(Thread.currentThread().getName()+" escogio tomar agua");
        }
        Thread.sleep(3000);
        mostradorDisponible.lock();
        this.cantDisponible++;
        System.out.println(Thread.currentThread().getName()+" termina de servir su almuerzo (en mostrador de almuerzo: "+(5-cantDisponible)+")");
        esperarMostradorAlmuerzo.signal();
        mostradorDisponible.unlock();
        return seleccionoGaseosa;
    }
}
