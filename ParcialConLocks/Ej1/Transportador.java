package ParcialConLocks.Ej1;

public class Transportador implements Runnable{
    private Fabrica fabrica;
    public Transportador(Fabrica f) {
        this.fabrica = f;
    }
    @Override
    public void run() {
        try {
            this.fabrica.iniciarReparto();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
