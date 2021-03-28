package demo;

public class Main {

    public static void main(String[] args) {
	 Persona[] pArr = {new Persona("LUIS", 19), new Persona("isa", 1), new Persona("josy", 30), new Persona("dani", 21)};
	 SortUtil.ordenar(pArr);
	 for (Persona p: pArr)
     {
         System.out.println(p.getNombre());
     }

        Celular[] cArr = {new Celular(56,"Luis"), new Celular(2, "JOsy"), new Celular(21, "isa")};
        SortUtil.ordenar(cArr);
        for (Celular p: cArr)
        {
            System.out.println(p.getTitular());
        }
    }
}
