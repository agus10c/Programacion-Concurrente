package Tp5.Ejercicio8;

import java.util.concurrent.Semaphore;

public class Cuerda {
    private Semaphore sSubir, sBajar, sTurno, sBalancear, mutex1, mutex2;
    private char turno;
    private int babuinosEnCuerda;
    private boolean balanceando;
    public Cuerda() {
        this.sSubir = new Semaphore(5);
        this.sBajar = new Semaphore(0);
        this.sTurno = new Semaphore(1);
        this.mutex1 = new Semaphore(1);
        this.mutex2 = new Semaphore(2);
        this.sBalancear = new Semaphore(0);
        this.babuinosEnCuerda = 0;
        this.turno = 'n';
        this.balanceando = false;
    }

    public void balancear() throws InterruptedException {
        sBalancear.acquire();
        balanceando = true;
        System.out.println(this.babuinosEnCuerda+" Babuinos balanceandose");
        Thread.sleep(2000);
        System.out.println("llegan al otro lado");
        this.balanceando = false;
        this.sBajar.release(this.babuinosEnCuerda);
    }
    public void subirCuerda(Babuino b) throws InterruptedException {
       while (!b.getPaso()) {
           mutex1.acquire();
           if(this.turno == 'n') {
               this.turno = b.getLado();
           }
           mutex1.release();
           if(this.turno == b.getLado()) {
               sSubir.acquire();
               System.out.println("sube un Babuino a la cuerda");
               mutex1.acquire();
               this.babuinosEnCuerda++;
               mutex1.release();
               mutex2.acquire();
               if (!this.balanceando ) {
                   sBalancear.release();
               }
               mutex2.release();
               this.bajarCuerda(b);
           } else {
               sTurno.acquire();
           }
       }
    }

    public void bajarCuerda(Babuino b) throws InterruptedException {
        sBajar.acquire();
        System.out.println("bajo un babuino");
        b.setPaso();
        if(b.getLado() == 'I') {
            b.setLado('D');
        } else {
            b.setLado('I');
        }
        mutex1.acquire();
        this.babuinosEnCuerda--;
        mutex1.release();
        if (this.babuinosEnCuerda==0) {
            this.sSubir.release(5);
        }
    }
}
