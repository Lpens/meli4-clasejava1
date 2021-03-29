package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Simpson {
    private String nombre;
    private String apellido;
    private List<String> hijos;
    private int edad;
    private boolean esposa;

}
