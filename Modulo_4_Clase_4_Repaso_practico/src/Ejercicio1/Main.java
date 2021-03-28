package Ejercicio1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        GuardaRopa nuevoGuarda = new GuardaRopa();
        ArrayList<Prenda> listaPrendas = new ArrayList<Prenda>();
        listaPrendas.add(new Prenda("addidas", "sport"));
        listaPrendas.add(new Prenda("Nike", "sport2"));
        Integer key = nuevoGuarda.guardarPrendas(listaPrendas);
        List<Prenda> p = nuevoGuarda.devolverPrendas(key);
        System.out.println("mostrando las prendas de la key: " + key);
        for (Prenda prenda : p) {
            System.out.println(prenda.toString());
        }
        System.out.println("mostrando todas las prendas");
        nuevoGuarda.mostrarPrendas();

    }
}
