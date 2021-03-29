package com.mercadolibre.metros.controllers;

import com.mercadolibre.metros.entity.CasaDTO;
import com.mercadolibre.metros.entity.ResponseDTO;
import com.mercadolibre.metros.services.CasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetrosController {

    @PostMapping("/casa")
    public ResponseEntity calcularMetrosCuadrados(@RequestBody CasaDTO casa)
    {
        try
        {
            ResponseDTO response = new ResponseDTO(CasaService.getMetrosTotales(casa),
                    CasaService.valorcasa(casa),
                    CasaService.habitacionGrande(casa),
                    CasaService.listaDeAreas(casa));
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
