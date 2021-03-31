package com.mercadolibre.foodcalculator.dto;

import java.util.List;


public class PlatoReturnDTO {
    private int caloriasTotales;
    private IngredienteDTO ingredienteCalorico;
    private List<Integer> listaDeCalorias;

    public int getCaloriasTotales() {
        return caloriasTotales;
    }

    public void setCaloriasTotales(int caloriasTotales) {
        this.caloriasTotales = caloriasTotales;
    }

    public IngredienteDTO getIngredienteCalorico() {
        return ingredienteCalorico;
    }

    public void setIngredienteCalorico(IngredienteDTO ingredienteCalorico) {
        this.ingredienteCalorico = ingredienteCalorico;
    }

    public List<Integer> getListaDeCalorias() {
        return listaDeCalorias;
    }

    public void setListaDeCalorias(List<Integer> listaDeCalorias) {
        this.listaDeCalorias = listaDeCalorias;
    }
}
