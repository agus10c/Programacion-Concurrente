package Tp5.Ejercicio7;

import java.util.concurrent.Semaphore;

public class Toboganes {
    private boolean t1Ocupado, t2Ocupado;
    private Semaphore sCliente, sEncargado, sTobogan, mutex1, mutex2;
    boolean fin;
    int t;
    int visitantesEsperando;
    public Toboganes() {
        this.t1Ocupado = false;
        this.t2Ocupado = false;
        this.sCliente = new Semaphore(1, true);
        this.sEncargado = new Semaphore(0);
        this.sTobogan = new Semaphore(0);
        this.fin = false;
        this.visitantesEsperando = 0;
        this.mutex1 = new Semaphore(1);
        this.mutex2 = new Semaphore(1);
    }

    public void esperar() throws InterruptedException {
        this.mutex1.acquire();
        this.visitantesEsperando++;
        this.mutex1.release();
    }
    public void usarTobogan() throws InterruptedException {
        System.out.println("Llega "+Thread.currentThread().getName());
        this.sCliente.acquire();
        this.mutex1.acquire();
        this.visitantesEsperando--;
        this.mutex1.release();
        this.sEncargado.release();
        this.sTobogan.acquire();
        int tob = this.obtenerTobogan();
        this.sCliente.release();
        System.out.println(Thread.currentThread().getName()+" se sube a Tobogan "+tob);
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+" se baja del Tobogan "+tob);
        if(tob == 1) {
            mutex2.acquire();
            this.t1Ocupado = false;
            mutex2.release();
        } else {
            mutex2.acquire();
            this.t2Ocupado = false;
            mutex2.release();
        }
        if(visitantesEsperando == 0) {
            this.fin = true;
        }
    }

    public int obtenerTobogan() {
        return t;
    }

    public void habilitarToboganes() throws InterruptedException {
        while (!fin) {
            this.sEncargado.acquire();
            boolean habilitado = false;
            while (!habilitado) {
                mutex2.acquire();
                if(!this.t1Ocupado) {
                    this.t1Ocupado = true;
                    t = 1;
                    habilitado = true;
                    this.sTobogan.release();
                } else if(!this.t2Ocupado) {
                    this.t2Ocupado = true;
                    t = 2;
                    habilitado = true;
                    this.sTobogan.release();
                }
                mutex2.release();
            }
        }
    }
}
