package Tp8.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Thread[] soldados = new Thread[30];
        MostradorAlmuerzo mostradorAlmuerzo = new MostradorAlmuerzo();
        MostradorPostre mostradorPostre = new MostradorPostre();
        Abridores abridores = new Abridores();
        for (int i = 0; i < 30; i++) {
            soldados[i] = new Thread(new Soldado(mostradorAlmuerzo, mostradorPostre, abridores), "Soldado "+(i+1));
            soldados[i].start();
        }
    }
}
