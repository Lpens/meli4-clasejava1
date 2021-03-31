package com.mercadolibre.foodcalculator.services;

import com.mercadolibre.foodcalculator.dto.PlatoDTO;
import com.mercadolibre.foodcalculator.dto.PlatoReturnDTO;

import java.util.List;

public interface PlatoCalculatorService {
    PlatoReturnDTO calcularPlato(PlatoDTO plato);
    List<PlatoReturnDTO> calcularListadoPlato(List<PlatoDTO> listadoPlatos);
}
