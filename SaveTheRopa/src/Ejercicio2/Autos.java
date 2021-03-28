package Ejercicio2;

public class Autos extends Vehiculo{

    public Autos(String patente, int aceleracion, int anguloDeGiro, int velocidad) {
        super(patente, aceleracion, anguloDeGiro, velocidad);
        this.setPeso(1000);
        this.setRuedas(4);
    }
}
