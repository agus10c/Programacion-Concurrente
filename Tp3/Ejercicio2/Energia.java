package Tp3.Ejercicio2;

public class Energia {
    private int cant;
    Energia(int cant) {
        this.cant = cant;
    }
    public synchronized int getCantEnergia() {
        return cant;
    }
    public synchronized void addCantEnergia(int i) {
        this.cant = this.cant+i;
    }
}
