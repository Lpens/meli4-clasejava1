package geometria;

public class DemoFiguraGeometrica {
    public static void main (String[] args)
    {
        FiguraGeometrica[] figureArr= {new Circulo(5), new Rectangulo(5,5), new Triangulo(10,15)};
        System.out.println(geometricsUtility.areaPromedio(figureArr));
    }
}
