/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.Ej8Rodri;

import java.util.concurrent.Semaphore;

/**
 *
 * @author beatriz
 */
public class Cuerda {
    private Semaphore semBinHaciaNorte;
    private Semaphore semBinHaciaSur;
    private Semaphore semGenCuerda;
    private Semaphore mutex;
     private int cantidadHaciaSur;//Cantidad de babuinos que se dirigen hacia el sur por el día
    private int cantidadHaciaNorte;//Cantidad de babuinos que se dirigen hacia el norte por el día
    private int contadorEnCuerda;//Contador de animales en cuerda
    private int contadorPorTurno;//Contador usado para cuando al pasar una cantidad de una dirección, cambie de direccion
    private int pasaronHaciaNorte, pasaronHaciaSur;//Contadores pasa saber cuantos babuinos pasaron para cada direccion
    
    public Cuerda(int cantidadHaciaNorte, int cantidadHaciaSur){
        semBinHaciaNorte=new Semaphore(1);//Comienza en 1 como sensor
        semBinHaciaSur=new Semaphore(0);
        semGenCuerda=new Semaphore(5,true); //5 babuinos y respeta orden
        mutex=new Semaphore(1,true);
        this.cantidadHaciaNorte=cantidadHaciaNorte;
        this.cantidadHaciaSur=cantidadHaciaSur;
        contadorEnCuerda=0;
        contadorPorTurno=0;
        pasaronHaciaNorte=0;
        pasaronHaciaSur=0;
    }
    
    public void pedirCuerda(char direccion)throws InterruptedException{
        if(direccion=='N'){
            semBinHaciaNorte.acquire();
            semGenCuerda.acquire();
            System.out.println("El babuino "+Thread.currentThread().getName()+" tomo la cuerda con direccion al Norte");
 
            contadorEnCuerda++;//Contador protegido
            contadorPorTurno++;
            cantidadHaciaNorte--;//Un babuino menos para cruzar
            
            if((contadorPorTurno<5)&&(cantidadHaciaNorte>0)){
                //Si todavía no pasaron 5 babuinos y quedan para pasar hacia norte
                semBinHaciaNorte.release();
            }

        }else{
            if(direccion=='S'){
                    semBinHaciaSur.acquire();
                    semGenCuerda.acquire();
                    System.out.println("El babuino "+Thread.currentThread().getName()+" tomo la cuerda con direccion al Sur");

                    contadorEnCuerda++;//Contador protegido
                    contadorPorTurno++;
                    cantidadHaciaSur--;//Un babuino menos para cruzar
                    if((contadorPorTurno<5)&&(cantidadHaciaSur>0)){
                        //Si todavía no pasaron 5 babuinos y quedan para pasar hacia sur
                        semBinHaciaSur.release();
                    }
            }
        }
    }
    
    public void soltarCuerda(char direccion)throws InterruptedException{
        if(direccion=='N'){
            semGenCuerda.release();
            contadorEnCuerda--;//Un animal menos en la cuerda
            pasaronHaciaNorte++;
            if((contadorEnCuerda==0)&&(cantidadHaciaSur>0)&&((contadorPorTurno==5)||(cantidadHaciaNorte==0))){
                //(contadorEnCuerda==0) No quedan babuinos colgados
                //(cantidadHaciaSur>0)Quedan babuinos del lado de enfrente
                //(contadorPorTurno==5)Para asegurarse de que pasen 5 por turno
                contadorPorTurno=0;
                semBinHaciaSur.release();
            }else{
                if((contadorEnCuerda==0)&&(cantidadHaciaSur==0)&&(cantidadHaciaNorte>0)){
                    //Si pasaron 5 babinos hacia el norte y no quedan para pasar hacia el sur, vuelven a pasar otros más hacia el norte
                    semBinHaciaNorte.release();
                    contadorPorTurno=0;
                }
             }
         }else{
            if(direccion=='S'){
                semGenCuerda.release();
                contadorEnCuerda--;//Un animal menos en la cuerda
                pasaronHaciaSur++;
                if((contadorEnCuerda==0)&&(cantidadHaciaNorte>0)&&((contadorPorTurno==5)||(cantidadHaciaSur==0))){
                    //(contadorPorTurno==5)Para asegurarse de que pasen 5 por turno
                     contadorPorTurno=0;
                     semBinHaciaNorte.release();
                }else{
                    if((contadorEnCuerda==0)&&(cantidadHaciaNorte==0)&&(cantidadHaciaSur>0)){
                        //Si pasaron 5 babinos hacia el sur y no quedan para pasar hacia el norte, vuelven a pasar otros más hacia el sur
                        semBinHaciaSur.release();
                        contadorPorTurno=0;
                    }
                }
            }
        }
        System.out.println("El babuino "+Thread.currentThread().getName()+" cruzó y solto la cuerda");
    }

    public int getPasaronHaciaNorte() {
        return pasaronHaciaNorte;
    }

    public int getPasaronHaciaSur() {
        return pasaronHaciaSur;
    }

}
