package Tp3.Ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class Visitante extends Thread{
    private AreaParqueTematico[] colAreas;
    Visitante(String nombre,  AreaParqueTematico[] areas) {
        super(nombre);
        colAreas = areas;
    }
    public void run() {
        Random random = new Random();
        AreaParqueTematico areaSeleccionada;
        int seleccion = random.nextInt(4)+1;
        int cantCupos = random.nextInt(7)+1;
        switch (seleccion) {
            case 1:
                areaSeleccionada = colAreas[0];
                System.out.println("El visitante "+this.getName()+" desea reservar "+cantCupos+ " cupos para "
                        + areaSeleccionada.getNombre());
                if(areaSeleccionada.verificarDisponibilidad(cantCupos)) {
                    areaSeleccionada.reservar(cantCupos);
                    System.out.println("reserva exitosa "+this.getName());
                } else {
                    System.out.println("reserva fallida "+this.getName());
                }
                break;
            case 2:
                areaSeleccionada = colAreas[1];
                System.out.println("El visitante "+this.getName()+" desea reservar "+cantCupos+ " cupos para "
                        + areaSeleccionada.getNombre());
                if(areaSeleccionada.verificarDisponibilidad(cantCupos)) {
                    areaSeleccionada.reservar(cantCupos);
                    System.out.println("reserva exitosa "+this.getName());
                } else {
                    System.out.println("reserva fallida "+this.getName());
                }
                break;
            case 3:
                areaSeleccionada = colAreas[2];
                System.out.println("El visitante "+this.getName()+" desea reservar "+cantCupos+ " cupos para "
                        + areaSeleccionada.getNombre());
                if(areaSeleccionada.verificarDisponibilidad(cantCupos)) {
                    areaSeleccionada.reservar(cantCupos);
                    System.out.println("reserva exitosa "+this.getName());
                } else {
                    System.out.println("reserva fallida "+this.getName());
                }
                break;
            case 4:
                areaSeleccionada = colAreas[3];
                System.out.println("El visitante "+this.getName()+" desea reservar "+cantCupos+ " cupos para "
                        + areaSeleccionada.getNombre());
                if(areaSeleccionada.verificarDisponibilidad(cantCupos)) {
                    areaSeleccionada.reservar(cantCupos);
                    System.out.println("reserva exitosa "+this.getName());
                } else {
                    System.out.println("reserva fallida "+this.getName());
                }
                break;
        }
    }
}
