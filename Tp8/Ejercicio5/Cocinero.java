package Tp8.Ejercicio5;

public class Cocinero implements Runnable{
    private Olla olla;
    public Cocinero(Olla olla) {
        this.olla = olla;
    }
    @Override
    public void run() {
        while (true) {
            try {
                olla.reponerOlla();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
