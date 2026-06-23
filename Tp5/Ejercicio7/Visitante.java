package Tp5.Ejercicio7;

public class Visitante implements Runnable{
    private Toboganes toboganes;
    public Visitante(Toboganes toboganes) {
        this.toboganes = toboganes;
    }

    @Override
    public void run() {
        try {
            this.toboganes.esperar();
            this.toboganes.usarTobogan();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
