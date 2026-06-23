package Tp2.ProductorConsumidorMonitores;

public class Consumidor implements Runnable{
    private Buffer buffer;
    public Consumidor(Buffer bufer){
        this.buffer=bufer;
    }

    @Override
    public void run() {
        while(true){
            try {
                buffer.sacar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
