package demo;

public class Persona implements Precedable <Persona>{
    private String nombre;
    private int dni;

    public Persona() {
        this.nombre = "testPersona";
        this.dni = 00000000;
    }

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public int precedeA(Persona o) {
        int resultado=0;
        if (this.dni<o.dni) {   resultado = -1;      }
        else if (this.dni>o.dni) {    resultado = 1;      }
        else {   resultado = 0;   }
        return resultado;
    }
}
