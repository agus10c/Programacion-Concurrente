package Tp8.Ejercicio5;

public class Canibal implements Runnable{
    private Olla olla;
    public Canibal(Olla olla) {
        this.olla = olla;
    }

    @Override
    public void run() {
        try {
            olla.comer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
