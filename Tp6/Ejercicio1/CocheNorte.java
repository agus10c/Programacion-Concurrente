package Tp6.Ejercicio1;

public class CocheNorte implements Runnable {
    private GestionarTrafico g;
    public CocheNorte (GestionarTrafico g) {
        this.g = g;
    }

    @Override
    public void run() {
        try {
            g.EntrarCocheDelNorte();
            g.salirCocheDelNorte();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
