package com.mercadolibre.foodcalculator.dto;

import lombok.Data;

@Data
public class IngredienteDTO {
    private String name;
    private int peso;
    private int calories;
}
