package Tp5.Ejercicio8;

public class Balancear implements Runnable {
    private Cuerda cuerda;

    public Balancear(Cuerda cuerda) {
        this.cuerda = cuerda;
    }

    @Override
    public void run() {
        try {
            this.cuerda.balancear();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
