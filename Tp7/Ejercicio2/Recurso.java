package Tp7.Ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Recurso {
    private final Lock mutex=new ReentrantLock();
    private final Condition libros;
    private final Condition compus;
    private int cantLibros, cantCompus, contadorL, contadorC;

    public Recurso (int lib, int com){
        this.libros= mutex.newCondition();
        this.compus= mutex.newCondition();
        this.cantLibros=lib;
        this.cantCompus=com;
        contadorL=lib;
        contadorC=com;
    }
    public void obtenerRecursos() throws InterruptedException {
        mutex.lock();
        this.pedirCompu();
        this.pedirLibro();
        mutex.unlock();
    }

    public void liberarRecursos() throws InterruptedException {
        mutex.lock();
        this.liberarCompu();
        this.liberarLibro();
        mutex.unlock();
    }

    private void pedirCompu() throws InterruptedException {
        while (contadorC==0){
            System.out.println(Thread.currentThread().getName()+" esperando compu");
            compus.await();
        }
        contadorC--;
    }



    private void liberarCompu() throws InterruptedException{
        contadorC++;
        compus.signal();
    }

    private void liberarLibro() throws InterruptedException{
        contadorL++;
        libros.signal();
    }



    private void pedirLibro() throws InterruptedException {
        while(contadorL==0 ){
            System.out.println(Thread.currentThread().getName()+" esperando libro");
            libros.await();
        }
        contadorL--;
    }
}
