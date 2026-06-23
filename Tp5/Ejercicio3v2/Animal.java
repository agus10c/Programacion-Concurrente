package Tp5.Ejercicio3v2;

public class Animal implements Runnable{
    private Comedor c;
    private boolean esPerro;

    public Animal(Comedor c, char a) {
        this.c = c;
        if(a == 'p') {
            esPerro = true;
        } else if(a == 'g') {
            esPerro = false;
        }
    }

    @Override
    public void run() {
        try {
            c.iniciar(this.esPerro);
            c.esperar(esPerro);
            c.comer(esPerro);
            c.dejarDeComer(esPerro);
        } catch (InterruptedException ex) {
        }
    }


}

