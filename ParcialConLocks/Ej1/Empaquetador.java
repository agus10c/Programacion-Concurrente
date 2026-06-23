package ParcialConLocks.Ej1;

public class Empaquetador implements Runnable {
    private Fabrica fabrica;
    public Empaquetador(Fabrica f) {
        this.fabrica = f;
    }
    @Override
    public void run() {
        while (true) {
            try {
                this.fabrica.empaquetarCaja();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
