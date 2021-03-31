package com.mercadolibre.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class MetricsDTO {
    private Double cantidadDeRedirecciones;
    private LinkDTO link;
}
