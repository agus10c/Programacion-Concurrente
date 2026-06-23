package Tp5.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Comedor comedor= new Comedor(3);
        Thread[] perros = new Thread[11];
        Thread[] gatos = new Thread[10];
        for (int i = 0; i < 10 ; i++) {
            perros[i] = new Thread(new Perro(comedor));
            gatos[i]= new Thread (new Gato(comedor));
            perros[i].start();
            gatos[i].start();
        }
        perros[10] = new Thread(new Perro(comedor));
        perros[10].start();
    }
}
