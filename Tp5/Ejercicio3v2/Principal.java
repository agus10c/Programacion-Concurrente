package Tp5.Ejercicio3v2;

public class Principal {
    public static void main(String[] args) {
        Comedor comedor = new Comedor(3, 5);
        Thread[] gatos = new Thread[10];
        Thread[] perros = new Thread[15];
        for (int i = 0; i < 10; i++) {
            gatos[i] = new Thread(new Animal(comedor, 'g'));
            gatos[i].start();
        }
        for (int i = 0; i < 15; i++) {
            perros[i] = new Thread(new Animal(comedor, 'p'));
            perros[i].start();
        }
    }
}

