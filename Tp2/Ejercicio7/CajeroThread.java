package Tp2.Ejercicio7;

public class CajeroThread extends Thread {
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    // Constructor, y métodos de acceso
    CajeroThread(String nombre, Cliente cliente ) {
        this.nombre = nombre;
        this.cliente = cliente;
    }
    public void esperarXsegundos(int seg) {
        try {
            Thread.sleep(seg*1000);
        } catch (InterruptedException exc) {
            System.out.println("Interrumpido.");
        }
    }
    public void run() {
        System.out.println("El cajero " + this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " " +
                    "del cliente " + this.cliente.getNombre() + "->Tiempo: " +
            (System.currentTimeMillis() - this.initialTime) / 1000
                    + "seg");
        }
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE " +
                "PROCESAR"+ this.cliente.getNombre() + " EN EL TIEMPO: " +
        (System.currentTimeMillis() - this.initialTime) / 1000 +
                "seg");
    }
}
class MainThread {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        CajeroThread cajero1 = new CajeroThread("cajero 1", cliente1);
        CajeroThread cajero2 = new CajeroThread("cajero 2", cliente2);
        cajero1.start();
        cajero2.start();
    }
}
