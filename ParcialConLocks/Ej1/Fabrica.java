package ParcialConLocks.Ej1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fabrica {
    private int cv, ca, espacioAlmacen;
    private Lock embotellarAgua = new ReentrantLock();
    private Lock embotellarVino = new ReentrantLock();
    private Lock empaquetarCaja = new ReentrantLock();
    private Lock transportar = new ReentrantLock();
    private Condition cajaVinoConLugar;
    private Condition cajaAguaConLugar;
    private Condition cajallena;
    private Condition alamacenLleno;


    public Fabrica() {
        this.cv = 0;
        this.ca = 0;
        this.espacioAlmacen = 100;
        cajaAguaConLugar = embotellarAgua.newCondition();
        cajaVinoConLugar = embotellarVino.newCondition();
        cajallena = empaquetarCaja.newCondition();
        alamacenLleno = transportar.newCondition();;
    }

    public void embotellarAgua() throws InterruptedException {
        embotellarAgua.lock();
        while(ca == 10) {
            cajaAguaConLugar.await();
        }
        this.ca++;
        System.out.println("embotella 1 agua, cant aguas en caja: "+ca);
        empaquetarCaja.lock();
        if(ca == 10) {
            System.out.println("caja agua llena");
            cajallena.signal();
        }
        embotellarAgua.unlock();
        empaquetarCaja.unlock();
    }

    public void embotellarVino() throws InterruptedException {
        embotellarVino.lock();
        while(cv == 10) {
            cajaVinoConLugar.await();
        }
        this.cv++;
        System.out.println("embotella 1 vino, cant vinos en caja: "+cv);
        empaquetarCaja.lock();
        if(cv == 10) {
            System.out.println("caja vino llena");
            cajallena.signal();
        }
        embotellarVino.unlock();
        empaquetarCaja.unlock();
    }
    public void empaquetarCaja() throws InterruptedException {
        empaquetarCaja.lock();
        while(ca != 10 && cv != 10) {
            cajallena.await();
        }
        if(ca >= 10) {
            System.out.println("Empaquetador repone caja de agua");
            ca = 0;
            embotellarAgua.lock();
            cajaAguaConLugar.signalAll();
            embotellarAgua.unlock();
        } else if(cv >= 10){
            System.out.println("Empaquetador repone caja de vino");
            cv = 0;
            embotellarVino.lock();
            cajaVinoConLugar.signalAll();
            embotellarVino.unlock();
        }
        transportar.lock();
        this.espacioAlmacen = this.espacioAlmacen-10;
        if(espacioAlmacen==0){
            System.out.println("almacen lleno");
            alamacenLleno.signal();
        }
        empaquetarCaja.unlock();
        transportar.unlock();
    }

    public void iniciarReparto() throws InterruptedException {
        transportar.lock();
        while(espacioAlmacen != 0) {
            alamacenLleno.await();
        }
        espacioAlmacen = 100;
        System.out.println("Sale un camion a hacer reparto");
        transportar.unlock();
    }
}
