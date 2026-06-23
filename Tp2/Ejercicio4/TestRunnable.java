package Tp2.Ejercicio4;

public class TestRunnable {
    public static void main (String [] args) {
        HiloRunnable hiloRunnable = new HiloRunnable();
        Thread hilo1 = new Thread(hiloRunnable, "Maria Jose");
        Thread hilo2 = new Thread(hiloRunnable,"Jose Maria");
        System.out.println("Termina thread main");
        hilo1.start();
        hilo2.start();
    }
}
