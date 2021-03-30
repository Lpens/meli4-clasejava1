package com.mercadolibre.diploma.entity;

import lombok.Data;

@Data
public class DiplomaDTO {
    private String mensaje;
    private double promedio;
    private AlumnoDTO alumno;
}
