package Tp6.Ejercicio1;

public class CocheSur implements Runnable {
        private GestionarTrafico g;
        public CocheSur (GestionarTrafico g) {
            this.g = g;
        }

        @Override
        public void run() {
            try {
                g.EntrarCocheDelSur();
                g.salirCocheDelSur();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}
