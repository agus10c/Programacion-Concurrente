package Tp3.Ejercicio2;

public class CriaturaOscura extends Thread{
    private Energia energia;
    CriaturaOscura(Energia energia) {
        super ("Criatura Oscura");
        this.energia = energia;
    }
    public void run() {
        int i = 0;
        while(energia.getCantEnergia()>0 && i<=20) {
            energia.addCantEnergia(-3);
            System.out.println("Energia -3: "+energia.getCantEnergia());
            i++;
        }
    }
}
