package Tp6.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Thread[] cochesNorte = new Thread[5];
        Thread[] cochesSur = new Thread[8];
        GestionarTrafico ges = new GestionarTrafico();
        for (int i = 0; i < 5; i++) {
            cochesNorte[i] = new Thread(new CocheNorte(ges));
            cochesNorte[i].start();
        }
        for (int i = 0; i < 8; i++) {
            cochesSur[i] = new Thread(new CocheSur(ges));
            cochesSur[i].start();
        }
    }
}
