package com.mercadolibre.metros.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private double metrosCuadradosTotales;
    private double Valor;
    private HabitacionDTO habitacionMasGrande;
    private List<Double> metrosPorHabitacion;
}
