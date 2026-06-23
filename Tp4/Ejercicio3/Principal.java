package Tp4.Ejercicio3;

public class Principal {
    public static void main(String[] args) {
        Proceso p1, p2, p3;
        Compartido c = new Compartido();
        p1 = new Proceso("p1", c, 1);
        p2 = new Proceso("p2", c, 2);
        p3 = new Proceso("p3", c, 3);
        p1.start();
        p2.start();
        p3.start();
    }
}
