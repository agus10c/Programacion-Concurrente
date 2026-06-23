package Tp5.Ejercicio7;

public class Main {
    public static void main(String[] args) {
        Thread[] visitantes = new Thread[8];
        Toboganes toboganes = new Toboganes();
        Thread encargado = new Thread(new Encargado(toboganes));
        encargado.start();
        for (int i = 0; i < 8; i++) {
            visitantes[i] = new Thread(new Visitante(toboganes), "Visitante "+(i+1));
            visitantes[i].start();
        }
    }
}
