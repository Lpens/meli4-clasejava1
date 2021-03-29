package com.mercadolibre.metros.services;

import com.mercadolibre.metros.entity.CasaDTO;
import com.mercadolibre.metros.entity.HabitacionDTO;

import java.util.ArrayList;
import java.util.List;

public class CasaService {

    public static double getMetrosTotales(CasaDTO casa)
    {
        double areaTotal =0;
        for (HabitacionDTO habitacion: casa.getHabitaciones())
        {
            areaTotal+= calcularAreaHab(habitacion);
        }
        return areaTotal;
    }
    private static double calcularAreaHab(HabitacionDTO habitacion)
    {
        return habitacion.getAncho() * habitacion.getLargo();
    }

    public static double valorcasa(CasaDTO casa)
    {
        return getMetrosTotales(casa) * 800;
    }

    public static HabitacionDTO habitacionGrande (CasaDTO casa)
    {
        HabitacionDTO bigger = new HabitacionDTO("lowest", 0, 0 );
        for(HabitacionDTO habitacion : casa.getHabitaciones())
        {
            bigger = calcularAreaHab(habitacion)> calcularAreaHab(bigger) ? habitacion : bigger;
        }

        return bigger;
    }

    public static List<Double> listaDeAreas(CasaDTO casa)
    {
        List <Double> lista = new ArrayList<>();
        for (HabitacionDTO habitacion : casa.getHabitaciones())
        {
            lista.add(calcularAreaHab(habitacion));
        }
        return lista;
    }
}
