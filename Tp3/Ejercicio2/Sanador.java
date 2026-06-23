package Tp3.Ejercicio2;

public class Sanador extends Thread {
    private Energia energia;
    Sanador(Energia energia) {
        super ("Sanador");
        this.energia = energia;
    }
    public void run() {
        int i = 0;
        while(energia.getCantEnergia()>0 && i<=20) {
            energia.addCantEnergia(3);
            System.out.println("Energia +3: "+energia.getCantEnergia());
            i++;
        }
    }
}
