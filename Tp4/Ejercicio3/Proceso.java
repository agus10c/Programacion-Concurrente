package Tp4.Ejercicio3;

public class Proceso extends Thread{
    private Compartido compartido;
    private int turno;
    public Proceso(String name, Compartido c, int turno) {
        super (name);
        this.compartido = c;
        this.turno = turno;
    }

    @Override
    public void run() {
    }
}
