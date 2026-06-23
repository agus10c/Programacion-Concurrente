package Tp2.ProductorConsumidorMonitores;

public class Productor implements Runnable {
    private Buffer buffer;
    public Productor(Buffer bufer){
        this.buffer=bufer;
    }

    @Override
    public void run() {
        while(true){
            try {
                buffer.poner();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
