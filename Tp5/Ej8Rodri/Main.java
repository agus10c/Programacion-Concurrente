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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuerda cuerda=new Cuerda(10,7);
        Babuino[] babuinosHaciaNorte=new Babuino[10];
        Babuino[] babuinosHaciaSur=new Babuino[7];
        Thread[] hilosHaciaNorte=new Thread[10];
        Thread[] hilosHaciaSur=new Thread[7];
        
        for(int i=0;i<babuinosHaciaNorte.length;i++){
            babuinosHaciaNorte[i]=new Babuino(cuerda,'N');
            hilosHaciaNorte[i]=new Thread(babuinosHaciaNorte[i]);
             hilosHaciaNorte[i].start();
            if(i<babuinosHaciaSur.length){
                babuinosHaciaSur[i]=new Babuino(cuerda,'S');
                hilosHaciaSur[i]=new Thread(babuinosHaciaSur[i]);
                 hilosHaciaSur[i].start();
            }
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}
