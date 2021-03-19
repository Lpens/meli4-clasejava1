package demo;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion()
    {}
    public Fraccion (int numerador, int denominador)
    {
        this.setDenominador(denominador);
        this.setNumerador(numerador);
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getDenominador() {
        return denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public Fraccion resta(Fraccion f)
    {
        Fraccion resultado = new Fraccion();
        int rNumerador =0;
        int rDenominador=0;
        if (this.getDenominador() == f.getDenominador())
        {
            rDenominador = this.getDenominador();
            rNumerador = this.getNumerador() + f.getNumerador();
        }
        else
        {
            rDenominador = this.getDenominador() * f.getDenominador();
            rNumerador = (this.getDenominador() * f.getNumerador() ) - (this.getNumerador() * f.getDenominador());
        }

        resultado.setDenominador(rDenominador);
        resultado.setNumerador(rNumerador);

        return resultado;
    }
    public Fraccion sumar(Fraccion f)
    {
        Fraccion resultado = new Fraccion();
        int rNumerador =0;
        int rDenominador=0;
        if (this.getDenominador() == f.getDenominador())
        {
            rDenominador = this.getDenominador();
            rNumerador = this.getNumerador() + f.getNumerador();
        }
        else
        {
            rDenominador = this.getDenominador() * f.getDenominador();
            rNumerador = (this.getDenominador() * f.getNumerador() )+ (this.getNumerador() * f.getDenominador());
        }

        resultado.setDenominador(rDenominador);
        resultado.setNumerador(rNumerador);

        return resultado;
    }
    public Fraccion dividir(Fraccion f)
    {
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(this.getNumerador() * f.getDenominador());
        resultado.setDenominador(this.getDenominador() * f.getNumerador());
        return resultado;
    }
    public  Fraccion multiplicar(Fraccion f)
    {
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(this.getNumerador() * f.getNumerador());
        resultado.setDenominador(this.getDenominador() * f.getDenominador());
        return resultado;
    }
    public Fraccion getNewFraccion(int n)
    {
        return new Fraccion(n,1);
    }
    public Fraccion resta(int n)
    {
        return  this.resta(this.getNewFraccion(n));
    }
    public Fraccion sumar(int n)
    {
        return this.sumar(this.getNewFraccion(n));
    }
    public Fraccion dividir(int n)
    {
        return this.dividir(this.getNewFraccion(n));
    }
    public  Fraccion multiplicar(int n)
    {
        return this.multiplicar(this.getNewFraccion(n));
    }
}
