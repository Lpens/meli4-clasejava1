package com.mercadolibre.foodcalculator.services;

import com.mercadolibre.foodcalculator.dto.PlatoDTO;
import com.mercadolibre.foodcalculator.dto.PlatoReturnDTO;
import com.mercadolibre.foodcalculator.exceptions.IngredientNotFound;

import java.util.List;

public interface PlatoCalculatorService {
    PlatoReturnDTO calcularPlato(PlatoDTO plato) throws IngredientNotFound;
    List<PlatoReturnDTO> calcularListadoPlato(List<PlatoDTO> listadoPlatos) throws IngredientNotFound;
}
