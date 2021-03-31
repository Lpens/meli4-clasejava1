package com.mercadolibre.foodcalculator.controllers;

import com.mercadolibre.foodcalculator.dto.ErrorDTO;
import com.mercadolibre.foodcalculator.dto.PlatoDTO;
import com.mercadolibre.foodcalculator.exceptions.IngredientNotFound;
import com.mercadolibre.foodcalculator.services.PlatoCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    private PlatoCalculatorService platoCalculatorService;

    @PostMapping("/calcular")
    public ResponseEntity calcularPlato(@RequestBody PlatoDTO plato) throws IngredientNotFound {
        return new ResponseEntity(platoCalculatorService.calcularPlato(plato), HttpStatus.OK);
    }

    @PostMapping("/calcular/listado")
    public ResponseEntity calcularListadoPlatos(@RequestBody List<PlatoDTO> listadoPlatos) throws IngredientNotFound {
        return new ResponseEntity(platoCalculatorService.calcularListadoPlato(listadoPlatos), HttpStatus.OK);
    }

    @ExceptionHandler(IngredientNotFound.class)
    public ResponseEntity handleException(IngredientNotFound errorException)
    {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Invalid Ingredient");
        errorDTO.setDescription("The ingredient " + errorException.getMessage() + "is invalid");
        return  new ResponseEntity(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
