package Tp2.Ejercicio4;

public class HiloRunnable implements Runnable {
    public void run() {
        String t;
        for (int i = 0; i < 10 ; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }
}
