package Tp3.Ejercicio5;

import java.security.spec.RSAOtherPrimeInfo;

public class Auto extends Vehiculo{
    private int patente;
    private String modelo;
    private String marca;
    private double km;
    private Surtidor surtidor;

    public Auto(int patente, String modelo, String marca, double combustiblexkm, Surtidor surtidor) {
        super(combustiblexkm);
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.km = 0;
        this.surtidor = surtidor;
    }
    public void cargarCombustible(int cant) {
        this.combustible = this.combustible + cant;
    }
    public int getPatente() {
        return patente;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public Double getKm() {
        return km;
    }
    public void andar(int cantKm) {
        if(this.descargarCombustible(cantKm)) {
            this.km = this.km + cantKm;
        } else {
            System.out.println("No alcanza el combustible para andar esa cant de km");
        }
    }
}
