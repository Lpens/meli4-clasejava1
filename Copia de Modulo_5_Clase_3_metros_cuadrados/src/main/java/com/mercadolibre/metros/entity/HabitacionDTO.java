package com.mercadolibre.metros.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitacionDTO {
    private  String nombre;
    private double ancho;
    private  double largo;
}
