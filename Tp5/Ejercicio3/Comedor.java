package Tp5.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore control, sGato, sPerro, mutex;
    private int cantLugares, perrosComiendo, gatosComiendo, perrosEsperando, gatosEsperando, contadorComidos;
    public Comedor(int cant) {
        contadorComidos = 0;
        perrosComiendo = 0;
        gatosComiendo = 0;
        perrosEsperando = 0;
        gatosEsperando = 0;
        cantLugares=cant;
        mutex = new Semaphore(1);
        sPerro = new Semaphore(cant);
        sGato = new Semaphore(0);
    }

    private void aumentarContador() throws InterruptedException {
        mutex.acquire();
        this.contadorComidos++;
        mutex.release();
    }

    public void esperarPerro() {
        this.perrosEsperando++;
    }

    public void esperarGato() {
        this.gatosEsperando++;
    }

    public void comerPerro() throws InterruptedException {
        sPerro.acquire();
        this.perrosEsperando--;
        this.perrosComiendo++;
        System.out.println("Perro comiendo");
        Thread.sleep(3000);
        this.perrosComiendo--;
        this.aumentarContador();
        System.out.println("Perro termino de comer");
        if(perrosComiendo==0) {
            if(contadorComidos > 4) {
                this.contadorComidos = 0;
                if(gatosEsperando > 0) {
                    sGato.release(cantLugares);
                } else {
                        sPerro.release(cantLugares);
                }
            } else {
                this.contadorComidos = 0;
                if(perrosEsperando > 0) {
                    sPerro.release(cantLugares);
                } else {
                    if(gatosEsperando > 0) {
                        sGato.release(cantLugares);
                    }
                }
            }
        }
    }
    public void comerGato () throws InterruptedException {
        sGato.acquire();
        this.gatosEsperando--;
        this.gatosComiendo++;
        System.out.println("Gato comiendo");
        Thread.sleep(3000);
        this.gatosComiendo--;
        this.aumentarContador();
        System.out.println("Gato termino de comer");
        if(gatosComiendo==0) {
            if(contadorComidos > 4) {
                this.contadorComidos = 0;
                if(perrosEsperando > 0) {
                    sPerro.release(cantLugares);
                } else {
                    sGato.release(cantLugares);
                }
            } else {
                this.contadorComidos = 0;
                if(gatosEsperando > 0) {
                    sGato.release(cantLugares);
                } else {
                    if(perrosEsperando > 0) {
                        sPerro.release(cantLugares);
                    }
                }
            }
        }
    }
}
