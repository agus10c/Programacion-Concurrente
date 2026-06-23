package Tp5.Ejercicio8;

public class Babuino implements Runnable {
    private String nombre;
    private char lado; //I(lado izq),  D(lado der)
    private Cuerda cuerda;
    private boolean paso;
    public Babuino(String nombre, char lado, Cuerda cuerda) {
        this.cuerda = cuerda;
        this.nombre = nombre;
        this.lado = lado;
        paso = false;
    }

    public String getNombre() {
        return nombre;
    }

    public char getLado() {
        return lado;
    }

    public void setLado(char lado) {
        this.lado = lado;
    }

    public boolean getPaso() {
        return paso;
    }

    public void setPaso() {
        this.paso = true;
    }

    @Override
    public void run() {
        try {
            this.cuerda.subirCuerda(this);
            this.cuerda.balancear();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
