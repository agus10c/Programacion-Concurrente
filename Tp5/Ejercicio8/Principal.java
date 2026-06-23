package Tp5.Ejercicio8;

public class Principal {
    public static void main(String[] args) {
        Thread[] babuinos = new Thread[11];
        Cuerda cuerda = new Cuerda();
        Thread balancerar = new Thread(new Balancear(cuerda));
        for (int i = 0; i < 7; i++) {
            babuinos[i] = new Thread(new Babuino("BabuinoD "+i, 'D', cuerda));
            babuinos[i].start();
        }
        for (int i = 7; i < 11; i++) {
            babuinos[i] = new Thread(new Babuino("BabuinoI "+i, 'I', cuerda));
            babuinos[i].start();
        }
        balancerar.start();
    }
}
