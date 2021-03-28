package demo;

public class Celular implements  Precedable <Celular>{
    private  int numero;
    private  String titular;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
        int resultado=0;
        if (this.numero<celular.numero) {   resultado = -1;      }
        else if (this.numero>celular.numero) {    resultado = 1;      }
        else {   resultado = 0;   }
        return resultado;
    }
}
