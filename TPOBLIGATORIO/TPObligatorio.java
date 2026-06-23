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
public class TPObligatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tren tren= new Tren();
        Thread[] pasajeros = new Thread[6];
        Thread control= new Thread (new ControlTren(tren));
        control.start();
        MaquinaTickets m = new MaquinaTickets(20);
        for (int i = 0; i < 6; i++) {
            pasajeros[i]= new Thread(new Pasajero(tren, m));
            pasajeros[i].start();
        }
    }
    
}
