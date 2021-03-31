package com.mercadolibre.metros.controllers;

import com.mercadolibre.metros.entity.CasaDTO;
import com.mercadolibre.metros.entity.ResponseDTO;
import com.mercadolibre.metros.services.CasaService;
import com.mercadolibre.metros.services.CasaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetrosController {

    private final CasaServiceImpl casaService;
    public MetrosController(CasaServiceImpl casaService)
    {
        this.casaService = casaService;
    }

    @PostMapping("/casa")
    public ResponseEntity calcularMetrosCuadrados(@RequestBody CasaDTO casa)
    {
        try
        {
            ResponseDTO response = new ResponseDTO(casaService.getMetrosTotales(casa),
                    casaService.valorcasa(casa),
                    casaService.habitacionGrande(casa),
                    casaService.listaDeAreas(casa));
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
