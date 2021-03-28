package Ejercicio2;

import java.util.*;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private  SocorristaMoto socorristaMoto = new SocorristaMoto();

    public void darDeAltaAuto(String patente, int aceleracion, int anguloDeGiro, int velocidad)
    {
        if(vehiculos.size() < cantidadDeVehiculosPermitidos)
        {
            vehiculos.add(new Autos(patente, aceleracion, anguloDeGiro,velocidad));
        }
    }

    public void darDeAltaMoto(String patente, int aceleracion, int anguloDeGiro, int velocidad)
    {
        if(vehiculos.size() < cantidadDeVehiculosPermitidos)
        {
            vehiculos.add(new Motos(patente, aceleracion, anguloDeGiro,velocidad));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo)
    {
        vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String unaPatente)
    {
        for(Vehiculo v: vehiculos)
        {
            if (v.getPatente() == unaPatente)
            {
                vehiculos.remove(v);
            }
        }
    }
    public Vehiculo getWinner()
    {
        SortedMap<Double, Vehiculo> vehiculosSortedList = new TreeMap<Double,Vehiculo>();
        // TODO necesito encontrar una forma de ordenar el arreglo de autos desde el mas rapido al mas lento lo que puedo hacer
        //es hacer un hashtable o treenode cuyo key sea el valor de la posicion de forma descendente.
        for (Vehiculo v: vehiculos)
        {
            double pos = v.getVelocidad() * (v.getAceleracion()*0.5)/ (v.getAngulodegiro()*(v.getPeso()-v.getRuedas()*100));
            vehiculosSortedList.put(pos, v);
        }
        return vehiculosSortedList.get(vehiculosSortedList.lastKey());
    }

    public Vehiculo getVehiculo(String unaPatente)
    {
        for(Vehiculo v: vehiculos)
        {
            if (v.getPatente() == unaPatente)
            {
                return v;
            }
        }
        return null;
    }

    public void socorrerAuto(String patente){
        Vehiculo v = this.getVehiculo(patente);
        if (v.getClass().getSimpleName() == "Autos")
        {
            socorristaAuto.socorrer((Autos) v);
        }
    }

    public void socorrerMoto(String patente){
        Vehiculo v = this.getVehiculo(patente);
        if (v.getClass().getSimpleName() == "Motos")
        {
            socorristaMoto.socorrer((Motos) v);
        }
    }
}
