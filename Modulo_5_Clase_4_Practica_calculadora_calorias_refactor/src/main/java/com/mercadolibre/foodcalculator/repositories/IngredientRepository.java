package com.mercadolibre.foodcalculator.repositories;

import com.mercadolibre.foodcalculator.dto.IngredienteDTO;
import com.mercadolibre.foodcalculator.exceptions.IngredientNotFound;

public interface IngredientRepository {
    IngredienteDTO findIngredientByName(String name) throws IngredientNotFound;
}
