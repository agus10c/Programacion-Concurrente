package Tp7.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Recurso recurso= new Recurso(2,2);
        Thread[] programadores = new Thread[6];
        for (int i = 0; i < 6; i++) {
            programadores[i]=new Thread (new Programador(recurso),"programador "+i);
            programadores[i].start();
        }
    }

}
