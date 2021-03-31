package com.mercadolibre.foodcalculator.dto;
import lombok.Data;
import java.util.List;

@Data
public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
}
