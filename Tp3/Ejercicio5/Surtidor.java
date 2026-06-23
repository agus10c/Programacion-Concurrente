package Tp3.Ejercicio5;

public class Surtidor {
    private double combustibleTotal;
    Surtidor(double cant) {
        this.combustibleTotal = cant;
    }

    public synchronized void cargar(double cant) {
        this.combustibleTotal = this.combustibleTotal+cant;
    }
    public synchronized void descargar(double cant) {
        this.combustibleTotal = this.combustibleTotal-cant;
    }
    public synchronized double getCombustibleTotal() {
        return this.combustibleTotal;
    }
}
