package ParcialConLocks.Ej1;

public class EmbotelladorAgua implements Runnable{
    private Fabrica fabrica;
    public EmbotelladorAgua(Fabrica f) {
        this.fabrica = f;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                this.fabrica.embotellarAgua();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
