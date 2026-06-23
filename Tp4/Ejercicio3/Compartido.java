package Tp4.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Compartido {
    Semaphore s12, s23, s31;
    Compartido() {
       s12 = new Semaphore(0);
       s23 = new Semaphore(0);
       s31 = new Semaphore(1);
    }
}
