/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.Ej8Rodri;

/**
 *
 * @author beatriz
 */
public class Babuino implements Runnable{
    private Cuerda cuerda;
    private char direccion; //Sera S para dirigirse hacia el sur y N para el norte

    public Babuino(Cuerda cuerda, char direccion) {
        this.cuerda = cuerda;
        this.direccion = direccion;
    }
    
    public void run(){
        try{
            if(direccion=='S'){
                System.out.println("El babuino "+Thread.currentThread().getName()+" llega a la cuerda con dirección al Sur");
            }else{
                if(direccion=='N'){
                    System.out.println("El babuino "+Thread.currentThread().getName()+" llega a la cuerda con dirección al Norte");
                }
            }
                cuerda.pedirCuerda(direccion);
                Thread.sleep(4000);//Cruza
                cuerda.soltarCuerda(direccion);
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
