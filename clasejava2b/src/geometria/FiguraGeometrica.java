package geometria;

public abstract class FiguraGeometrica {
    public abstract  double area();

    @Override
    public String toString()
    {
        return "el area de la figura es: " + area();
    }
}
