package Tp3.Ejercicio2;

public class Principal {
    public static void main(String[] args) {
        int Energia = 10;
        Energia energia = new Energia(10);
        CriaturaOscura hilo1 = new CriaturaOscura(energia);
        Sanador hilo2 = new Sanador(energia);
        hilo1.start();
        hilo2.start();
    }
}
