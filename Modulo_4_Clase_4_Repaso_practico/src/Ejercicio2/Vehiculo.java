package Ejercicio2;

public abstract class Vehiculo {
    private int velocidad;
    private int aceleracion;
    private int angulodegiro;
    private String patente;
    private int peso;
    private int Ruedas;

    public Vehiculo(String patente, int aceleracion, int anguloDeGiro, int velocidad)
    {
        this.setAceleracion(aceleracion);
        this.setAngulodegiro(anguloDeGiro);
        this.setVelocidad(velocidad);
        this.setPatente(patente);
    }
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;
    }

    public int getAngulodegiro() {
        return angulodegiro;
    }

    public void setAngulodegiro(int angulodegiro) {
        this.angulodegiro = angulodegiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return Ruedas;
    }

    public void setRuedas(int ruedas) {
        Ruedas = ruedas;
    }
}
