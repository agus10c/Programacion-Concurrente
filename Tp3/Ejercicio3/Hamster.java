package Tp3.Ejercicio3;

import java.util.Random;

public class Hamster implements Runnable{
    private String nombre;
    Hamster(String nombre) {
        this.nombre = nombre;
    }
    public synchronized void descansar(int seg) throws InterruptedException {
        System.out.println(this.nombre+" descansando");
        Thread.sleep(seg*1000);
        System.out.println(this.nombre+" dejo de descansar");
    }
    public synchronized void comer(int seg) throws InterruptedException{
        System.out.println(this.nombre+" comiendo");
        Thread.sleep(seg*1000);
        System.out.println(this.nombre+" termino de comer");
    }
    public synchronized void hacerEjercicio(int seg) throws InterruptedException{
        System.out.println(this.nombre+" en la rueda");
        Thread.sleep(seg*1000);
        System.out.println(this.nombre+" dejo la rueda");
    }
    public void run() {
        try {
            for(int i = 1; i<=3; i++) {
                Random random = new Random();
                int numeroAleatorio = random.nextInt(3) + 1;
                switch (numeroAleatorio) {
                    case 1:
                        this.comer(10);
                        break;
                    case 2:
                        this.hacerEjercicio(17);
                        break;
                    case 3:
                        this.descansar(24);
                        break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println("Interrumpido");
        }
    }
}
