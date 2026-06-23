package Tp5.Ejercicio7;

public class Encargado implements Runnable{
    private Toboganes toboganes;
    public Encargado(Toboganes toboganes) {
        this.toboganes = toboganes;
    }
    @Override
    public void run() {
        try {
            toboganes.habilitarToboganes();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
