package Tp7.Ejercicio2;

public class Programador implements Runnable{
    private Recurso recurso;
    public Programador (Recurso recu){
        this.recurso=recu;
    }


    public void run() {
        try {
            recurso.obtenerRecursos();
            System.out.println(Thread.currentThread().getName()+" Comienza a trabajar");
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName()+" Termina de trabajar");
            recurso.liberarRecursos();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
