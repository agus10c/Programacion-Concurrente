/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPOBLIGATORIO;

import java.util.concurrent.Semaphore;

/**
 *
 * @author alumno
 */
public class ControlTren implements Runnable {

    private Tren tren;

    public ControlTren(Tren t) {
        this.tren = t;
    }

    public void run() {
        while (true) {
            try {
                tren.andar();
            } catch (InterruptedException e) {
                System.out.println("asd");
            }
        }
    }
}
