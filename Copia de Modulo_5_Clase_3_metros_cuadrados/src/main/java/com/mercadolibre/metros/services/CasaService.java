package com.mercadolibre.metros.services;

import com.mercadolibre.metros.entity.CasaDTO;
import com.mercadolibre.metros.entity.HabitacionDTO;

import java.util.List;

public interface CasaService {

    double getMetrosTotales(CasaDTO casa);
    double calcularAreaHab(HabitacionDTO habitacion);
    double valorcasa(CasaDTO casa);
    HabitacionDTO habitacionGrande (CasaDTO casa);
    List<Double> listaDeAreas(CasaDTO casa);
}
