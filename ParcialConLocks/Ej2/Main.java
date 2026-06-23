package ParcialConLocks.Ej2;

public class Main {
    public static void main(String[] args) {
        Recipiente recipiente= new Recipiente(3);
        Thread[] hidrogenos= new Thread[50];
        Thread[] oxigenos= new Thread[50];
        for (int i = 0; i < 50; i++) {
            hidrogenos[i]= new Thread(new Hidrogeno(recipiente));
            hidrogenos[i].start();
        }
        for (int i = 0; i < 50; i++) {
            oxigenos[i]= new Thread (new Oxigeno(recipiente));
            oxigenos[i].start();
        }
    }
}
