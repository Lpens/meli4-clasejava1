package Ejercicio1;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    HashMap<Integer, List<Prenda>> prendaList = new HashMap<Integer, List<Prenda>>();
    Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda)
    {
        prendaList.put(contador,listaDePrenda);
        return contador++;

    }

    public void mostrarPrendas()
    {
        prendaList.forEach((k,v)->{
            System.out.println("Lista de prendas " + k + " : ");
            for (Prenda prenda : v) {
                System.out.println(prenda.toString());
            }
        });
    }

    public List<Prenda> devolverPrendas(Integer numero)
    {
        List<Prenda> prendas = prendaList.get(numero);
        prendaList.remove(numero);
        return prendas;
    }
}
