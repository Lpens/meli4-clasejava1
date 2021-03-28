package geometria;

public class Circulo extends  FiguraGeometrica{
    private double radio;

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Circulo(double radio) {
        this.radio = radio;
    }
    public double area()
    {
        return Math.PI * Math.pow(radio,2);
    }
}
