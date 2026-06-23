package Tp2.Ejercicio5;

public class MiHiloSinRunn extends Thread{
    MiHiloSinRunn(String nombre) {
        super(nombre);
    }
    public void run(){
        System.out.println("Comenzando "+this.getName());
        try {
            for (int contar=0; contar<10; contar++){
                Thread.sleep(400);
                System.out.println("En "+this.getName()+", el recuento "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(this.getName() + "Interrumpido.");
        }
        System.out.println("Terminando "+this.getName());
    }
}
class UsoHilosSinRunn{
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
//Primero, construye un objeto unHilo.
        MiHiloSinRunn mh=new MiHiloSinRunn("#1");
//Finalmente, comienza la ejecución del hilo.
        mh.start();
        for (int i=0; i<50;i++){
            System.out.print(" .");
        }try{
            Thread.sleep(100);
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }}
