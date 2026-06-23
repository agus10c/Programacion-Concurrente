package Tp2.Ejercicio6;

public class Carrera {
    public static void main(String[] args) {
        Corredor[] corredores = new Corredor[10];
        corredores[0] = new Corredor("Usain Bolt");
        corredores[1] = new Corredor("Messi");
        corredores[2] = new Corredor("Cr7");
        corredores[3] = new Corredor("Mbappe");
        corredores[4] = new Corredor("Flash");
        corredores[5] = new Corredor("Quicksilver");
        corredores[6] = new Corredor("Goku");
        corredores[7] = new Corredor("Vegeta");
        corredores[8] = new Corredor("Rayo macuin");
        corredores[9] = new Corredor("Sonic Ex");
        for(int i = 0; i<=9; i++) {
            corredores[i].start();
        }
        for(int i = 0; i<=9; i++) {
            try {
                corredores[i].join();
            } catch (InterruptedException exc){
                System.out.println("Interrumpido.");
            }
        }
        for(int i = 0; i<=9; i++) {
            System.out.println("Posicion "+(i+1)+": " + Corredor.posiciones.get(i).getName() + ", Distancia Recorrida: "
                    + Corredor.posiciones.get(i).getDistanciaRecorrida());
        }
    }
}
