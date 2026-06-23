package Tp8.Ejercicio5;

public class Main {
    public static void main(String[] args) {
        Olla olla = new Olla(4);
        Thread [] canibales= new Thread[7];
        for (int i = 0; i < 7; i++) {
            canibales[i]= new Thread (new Canibal(olla));
            canibales[i].start();
        }
        Thread cocinero = new Thread(new Cocinero(olla));
        cocinero.start();
    }
}
