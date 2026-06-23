package Tp5.Ejercicio3;

public class Perro implements Runnable{
    private Comedor c;
    public Perro(Comedor c) {
        this.c = c;
    }
    @Override
    public void run() {
        try {
            c.esperarPerro();
            c.comerPerro();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
