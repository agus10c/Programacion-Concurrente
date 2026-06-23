/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPOBLIGATORIO;

/**
 *
 * @author alumno
 */
public class Pasajero implements Runnable {

    private Tren tren;
    private MaquinaTickets m;

    public Pasajero(Tren t, MaquinaTickets maquinaTickets) {
        tren=t;
        this.m = maquinaTickets;
    }

    public void run() {
        while (true) {
            try {
                if(m.comprarTicket()) {
                    tren.subir();
                    //le da el pie al control para que de la vuelta
                    tren.bajar();
                }
            } catch (InterruptedException e) {
                System.out.println("asd");
            }
        }
    }
}
