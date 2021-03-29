package com.mercadolibre.calculadoraedades.controller;

import com.mercadolibre.calculadoraedades.services.DateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year)
    {
        return new ResponseEntity(DateService.GetEdad(day, month, year), HttpStatus.OK);
    }

    @GetMapping("/edad")
    public ResponseEntity getAgwParams(@RequestParam int day, @RequestParam int month, @RequestParam int year)
    {
        return new ResponseEntity(DateService.GetEdad(day, month, year), HttpStatus.OK);
    }
}
