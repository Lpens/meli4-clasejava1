package com.mercadolibre.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteSuccessDTO {

    private  String message;
    private LinkDTO link;
}
