package Ejercicio2;

public class Motos extends Vehiculo{
    public Motos(String patente, int aceleracion, int anguloDeGiro, int velocidad) {
        super(patente, aceleracion, anguloDeGiro, velocidad);
        this.setPeso(300);
        this.setRuedas(2);
    }
}
