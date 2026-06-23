package Tp2.Ejercicio6;

import java.util.ArrayList;
import java.util.Random;

public class Corredor extends Thread{
    private int distanciaRecorrida;
    static ArrayList<Corredor> posiciones;
    Corredor(String nombre) {
        super(nombre);
        this.distanciaRecorrida = 0;
        posiciones = new ArrayList<>();
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    private void actualizarPosicion() {
        posiciones.add(this);
    }
    public void run() {
        Random random = new Random();
        try {
            while(distanciaRecorrida<100) {
                distanciaRecorrida = this.distanciaRecorrida + (random.nextInt(10) + 1);
                System.out.println("soy "+this.getName() + " Recorri: "+distanciaRecorrida);
                Thread.sleep(100);
                if(distanciaRecorrida>100) {
                    this.actualizarPosicion();
                }
            }
        }catch (InterruptedException exc){
            System.out.println(this.getName() + "Interrumpido.");
        }
    }
}
