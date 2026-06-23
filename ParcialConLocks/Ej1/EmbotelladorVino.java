package ParcialConLocks.Ej1;

public class EmbotelladorVino implements Runnable{
    private Fabrica fabrica;
    public EmbotelladorVino(Fabrica f) {
        this.fabrica = f;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                this.fabrica.embotellarVino();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
