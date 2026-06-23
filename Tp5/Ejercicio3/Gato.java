package Tp5.Ejercicio3;

public class Gato implements Runnable{
    private Comedor c;
    public Gato (Comedor comedor){
        this.c=comedor;
    }
    @Override
    public void run() {
        try {
            c.esperarGato();
            c.comerGato();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
