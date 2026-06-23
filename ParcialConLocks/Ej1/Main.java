package ParcialConLocks.Ej1;

public class Main {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();
        Thread transportador = new Thread(new Transportador(fabrica));
        Thread empaquetador = new Thread(new Empaquetador(fabrica));
        Thread embotelladoresAgua;
        Thread embotelladoresVino;
        transportador.start();
        empaquetador.start();
        for (int i = 0; i < 3; i++) {
            embotelladoresAgua = new Thread(new EmbotelladorAgua(fabrica));
            embotelladoresAgua.start();
        }
        for (int i = 0; i < 3; i++) {
            embotelladoresVino = new Thread(new EmbotelladorVino(fabrica));
            embotelladoresVino.start();
        }
    }

}
