package demo;

public class Contador {
    private int valor;

    public Contador ()
    {
        this.valor =0;
    }

    public Contador ( int valor)
    {
        this.valor = valor;
    }

    public Contador (Contador copyCont)
    {
        this.valor = copyCont.getValor();
    }

    public int getValor() {
        return valor;
    }

    public void incrementar()
    {
        valor+=1;
    }
    public  void incrementar(int valor)
    {
        this.valor +=valor;
    }

    public void decrementar()
    {
        valor -=1;
    }

    public void decrementar(int valor)
    {
        this.valor -= valor;
    }
}
