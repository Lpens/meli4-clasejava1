package com.example.demo.services;

import com.example.demo.entities.Estudiante;
import com.example.demo.entities.Potter;
import com.example.demo.entities.Simpson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class PostmanServices {

    public static ResponseEntity buscarPersonaje(String name) {
        if (name.equals("harry"))
        {
            List<String> colores = new ArrayList<String>();
            colores.add("Amarillo");
            colores.add("Bordó");
            List<Estudiante> estudiantes= new ArrayList<>();
            estudiantes.add(new Estudiante("Harry", "Potter"));
            estudiantes.add(new Estudiante("Hermione", "Granger"));
            estudiantes.add(new Estudiante("Ron", "weasley"));
            Potter harry = new Potter("Griffindor", colores,estudiantes);
            return  new ResponseEntity(harry, HttpStatus.OK);
        }
        else
        {
            List<String> hijos = new ArrayList<>();
            hijos.add("bart");
            hijos.add("Lisa");
            hijos.add("Maggie");
            Simpson homero = new Simpson("Homero", "Simpson", hijos,40,true);
            return new ResponseEntity(homero,HttpStatus.OK);
        }


    }

    public static ResponseEntity mapearSimpson(Simpson personaje) {
        return new ResponseEntity(personaje, HttpStatus.OK);
    }

    public static ResponseEntity mapearPotter(Potter personaje) {
        return new ResponseEntity(personaje, HttpStatus.OK);
    }
}
