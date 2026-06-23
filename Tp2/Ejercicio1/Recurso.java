package Tp2.Ejercicio1;

public class Recurso {

    static void uso() {
        Thread t = Thread.currentThread();
        System.out.println("en Computadora: Soy" + t.getName());
    }
}
