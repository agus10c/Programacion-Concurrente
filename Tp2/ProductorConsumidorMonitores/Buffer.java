package Tp2.ProductorConsumidorMonitores;

public class Buffer{
    private int cant, contador;
    public Buffer(int cant) {
        this.cant = cant;
        this.contador = 0;
    }
    public synchronized void poner() throws InterruptedException {
        boolean continuar = true;
        while(continuar) {
            if(cant>contador) {
                this.contador++;
                continuar = false;
            }else{
                this.wait();
            }
        }
    }
    public synchronized void sacar() throws InterruptedException {
        boolean continuar = true;
        while(continuar) {
            if(contador>0){
                contador--;
                this.notifyAll();
                continuar = false;
            }else{
                this.wait();
            }
        }
    }
}
