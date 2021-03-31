package com.mercadolibre.foodcalculator.repositories;

import com.mercadolibre.foodcalculator.dto.IngredienteDTO;

public interface IngredientRepository {
    IngredienteDTO findIngredientByName(String name);
}
