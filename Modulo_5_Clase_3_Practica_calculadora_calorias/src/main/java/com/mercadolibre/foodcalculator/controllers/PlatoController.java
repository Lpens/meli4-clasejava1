package com.mercadolibre.foodcalculator.controllers;

import com.mercadolibre.foodcalculator.dto.PlatoDTO;
import com.mercadolibre.foodcalculator.services.PlatoCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    private PlatoCalculatorService platoCalculatorService;

    @PostMapping("/calcular")
    public ResponseEntity calcularPlato(@RequestBody PlatoDTO plato)
    {
        return new ResponseEntity(platoCalculatorService.calcularPlato(plato), HttpStatus.OK);
    }

    @PostMapping("/calcular/listado")
    public ResponseEntity calcularListadoPlatos(@RequestBody List<PlatoDTO> listadoPlatos)
    {
        return new ResponseEntity(platoCalculatorService.calcularListadoPlato(listadoPlatos), HttpStatus.OK);
    }
}
