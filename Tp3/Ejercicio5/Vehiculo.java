package Tp3.Ejercicio5;

public class Vehiculo {
     double combustible;
     private double combustiblexkm;
     Vehiculo(double comxkm) {
         this.combustible = (double)0;
         this.combustiblexkm = comxkm;
     }
     public boolean descargarCombustible(double km) {
         boolean r;
         double combustibleTotal = km*combustiblexkm;
         if(combustibleTotal <= this.combustible) {
             this.combustible = this.combustible - combustibleTotal;
             r = true;
         } else {
             r = false;
         }
         return r;
    }
}
