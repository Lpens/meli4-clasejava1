package com.mercadolibre.metros.services;

import com.mercadolibre.metros.entity.CasaDTO;
import com.mercadolibre.metros.entity.HabitacionDTO;
import com.mercadolibre.metros.entity.PriceDTO;
import com.mercadolibre.metros.repositories.PriceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CasaServiceImpl implements CasaService{
    @Autowired
    private PriceRepositoryImpl priceRepository;

    public double getMetrosTotales(CasaDTO casa)
    {
        double areaTotal =0;
        for (HabitacionDTO habitacion: casa.getHabitaciones())
        {
            areaTotal+= calcularAreaHab(habitacion);
        }
        return areaTotal;
    }
    public double calcularAreaHab(HabitacionDTO habitacion)
    {
        return habitacion.getAncho() * habitacion.getLargo();
    }

    public double valorcasa(CasaDTO casa)
    {
        PriceDTO priceByLocation = priceRepository.findPriceByLocation(casa.getLocation());

        double price = priceByLocation != null ? priceByLocation.getPrice():800;
        return getMetrosTotales(casa) * price;
    }

    public HabitacionDTO habitacionGrande (CasaDTO casa)
    {
        HabitacionDTO bigger = new HabitacionDTO("lowest", 0, 0 );
        for(HabitacionDTO habitacion : casa.getHabitaciones())
        {
            bigger = calcularAreaHab(habitacion)> calcularAreaHab(bigger) ? habitacion : bigger;
        }

        return bigger;
    }

    public List<Double> listaDeAreas(CasaDTO casa)
    {
        List <Double> lista = new ArrayList<>();
        for (HabitacionDTO habitacion : casa.getHabitaciones())
        {
            lista.add(calcularAreaHab(habitacion));
        }
        return lista;
    }
}
