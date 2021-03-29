package com.example.demo.controllers;

import com.example.demo.entities.Potter;
import com.example.demo.entities.Simpson;
import com.example.demo.services.PostmanServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personajes")
public class PostmanController {
    @GetMapping("/{name}")
    public ResponseEntity obtenerInfo (@PathVariable String name)
    {
        return PostmanServices.buscarPersonaje(name);
    }

    @PostMapping("/homero")
    public ResponseEntity enviarSimpson(@RequestBody Simpson personaje)
    {
        return PostmanServices.mapearSimpson(personaje);
    }

    @PostMapping("/harry")
    public ResponseEntity enviarSimpson(@RequestBody Potter personaje)
    {
        return PostmanServices.mapearPotter(personaje);
    }
}
