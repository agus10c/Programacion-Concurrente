package Tp5.Ejercicio3v2;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore sPerros, sGatos, mutex1, mutex2,mutex3;
    private int cantPlatos, gatosEsperando, perrosEsperando, animalesComidos,
            perrosComiendo, gatosComiendo, limite;
    private boolean inicio;

    public Comedor(int cantPlatos, int cantLim) {
        this.inicio = true;
        this.cantPlatos = cantPlatos;
        this.limite = cantLim;
        this.mutex1 = new Semaphore(1);
        this.mutex2 = new Semaphore(1);
        this.mutex3 = new Semaphore(1);
        this.sPerros = new Semaphore(0);
        this.sGatos = new Semaphore(0);
        this.animalesComidos = 0;
    }


    public void iniciar(boolean esPerro) throws InterruptedException {
        mutex3.acquire();
        if(inicio) {
            if(esPerro) {
                sPerros.release(this.cantPlatos);
            } else {
                sGatos.release(this.cantPlatos);
            }
            inicio = false;
        }
        mutex3.release();
    }


    public void esperar(boolean esPerro) throws InterruptedException {
        if (esPerro) {
            mutex1.acquire();
            this.perrosEsperando++;
            mutex1.release();
        } else {
            mutex1.acquire();
            this.gatosEsperando++;
            mutex1.release();
        }
    }

    public void comer(boolean esPerro) throws InterruptedException {
        if (esPerro) {
            this.sPerros.acquire();
            mutex1.acquire();
            this.perrosEsperando--;
            mutex1.release();
            mutex2.acquire();
            this.perrosComiendo++;
            System.out.println(" Perro comenzo a comer, perros comiendo: "+this.perrosComiendo);
            mutex2.release();
            Thread.sleep(2000);
        } else {
            this.sGatos.acquire();
            mutex1.acquire();
            this.gatosEsperando--;
            mutex1.release();
            mutex2.acquire();
            this.gatosComiendo++;
            System.out.println(" Gato comenzo a comer, gatos comiendo: "+this.gatosComiendo);
            mutex2.release();
            Thread.sleep(2000);
        }
    }

    public void dejarDeComer(boolean esPerro) throws InterruptedException {
        if (esPerro) {
            mutex2.acquire();
            this.perrosComiendo--;
            this.animalesComidos++;
            System.out.println(" Perro dejo de comer, perros comiendo: "+this.perrosComiendo);
            if (this.perrosComiendo == 0) {
                if (this.animalesComidos >= this.limite) {
                    if(this.gatosEsperando > 0) {
                        this.animalesComidos = 0;
                        this.sGatos.release(this.cantPlatos);
                    } else if(this.perrosEsperando > 0) {
                        this.animalesComidos = 0;
                        this.sPerros.release(this.cantPlatos);
                    }
                } else {
                    if(this.perrosEsperando > 0) {
                        this.sPerros.release(this.cantPlatos);
                    } else if(this.gatosEsperando>0) {
                        this.animalesComidos = 0;
                        this.sGatos.release(this.cantPlatos);
                    }
                }
            }
            mutex2.release();
        } else {
            mutex2.acquire();
            this.gatosComiendo--;
            this.animalesComidos++;
            System.out.println("Gato dejo de comer, gatos comiendo: "+this.gatosComiendo);
            if (this.gatosComiendo == 0) {
                if (this.animalesComidos >= this.limite) {
                    if(this.perrosEsperando > 0) {
                        this.animalesComidos = 0;
                        this.sPerros.release(this.cantPlatos);
                    } else if(this.gatosEsperando > 0) {
                        this.animalesComidos = 0;
                        this.sGatos.release(this.cantPlatos);
                    }
                } else {
                    if(this.gatosEsperando > 0) {
                        this.sGatos.release(this.cantPlatos);
                    } else if(this.perrosEsperando>0) {
                        this.animalesComidos = 0;
                        this.sPerros.release(this.cantPlatos);
                    }
                }
            }
            mutex2.release();
        }
    }
}
