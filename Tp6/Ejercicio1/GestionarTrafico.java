package Tp6.Ejercicio1;

public class GestionarTrafico {
    private int cantAutosSur;
    private int cantAutosNorte;
    public GestionarTrafico() {
            this.cantAutosNorte = 0;
            this.cantAutosSur = 0;
    }
    public synchronized void EntrarCocheDelNorte() throws InterruptedException {
        while (this.cantAutosSur != 0) {
            this.wait();
        }
        this.cantAutosNorte++;
        System.out.println("Entra coche del norte, coches del norte: "+this.cantAutosNorte);
    }
    public synchronized void EntrarCocheDelSur() throws InterruptedException {
        while (this.cantAutosNorte != 0) {
            this.wait();
        }
        this.cantAutosSur++;
        System.out.println("Entrar coche del sur, coches del sur: "+this.cantAutosSur);
    }
    public synchronized void salirCocheDelNorte() {
        this.cantAutosNorte--;
        System.out.println("Salir coche del norte, coches del norte: "+this.cantAutosNorte);
        this.notifyAll();
    }
    public synchronized void salirCocheDelSur() {
        this.cantAutosSur--;
        System.out.println("Salir coche del sur, coches del sur: "+this.cantAutosSur);
        this.notifyAll();
    }

    }
