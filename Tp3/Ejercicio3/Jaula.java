package Tp3.Ejercicio3;

public class Jaula {
    public static void main(String[] args) {
        Hamster h1, h2, h3;
        h1 = new Hamster("messi");
        h2 = new Hamster("elBicho");
        h3 = new Hamster("elReyRata");
        Thread messi, elBicho, elReyRata;
        messi = new Thread(h1);
        elBicho =new Thread(h2);
        elReyRata = new Thread(h3);
        messi.start();
        elBicho.start();
        elReyRata.start();
    }
}
