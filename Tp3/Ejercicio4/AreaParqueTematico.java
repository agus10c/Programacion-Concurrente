package Tp3.Ejercicio4;

public class AreaParqueTematico {
    private int cupos;
    private String nombre;
    AreaParqueTematico(String nom, int cupos) {
        this.nombre = nom;
        this.cupos = cupos;
    }
    public synchronized void reservar(int cant) {
        this.cupos = this.cupos-cant;
    }
    public synchronized boolean verificarDisponibilidad(int cant) {
        return cant<=cupos;
    }
    public synchronized String getNombre() {
        return this.nombre;
    }
}
