package Tp8.Ejercicio1;

import java.util.Random;

public class Soldado implements Runnable{
    private MostradorAlmuerzo ma;
    private MostradorPostre mp;
    private Abridores a;
    public Soldado(MostradorAlmuerzo ma, MostradorPostre mp, Abridores a) {
        this.ma = ma;
        this.mp = mp;
        this.a = a;
    }
    public boolean quiereAlmuerzo() {
        Random r = new Random();
        return r.nextBoolean();
    }
    @Override
    public void run() {
        try {
            if(ma.buscarAlmuerzo()) {
                a.usarAbridor();
            }
            Thread.sleep(4000);
            if(this.quiereAlmuerzo()) {
                mp.buscarPostre();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
