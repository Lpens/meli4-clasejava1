package demo;

public class CuentaCorriente {
    private int cbu;
    private double saldo;
    private String beneficiario;


    public CuentaCorriente()
    {
        this.setSaldo(0);
        this.setCbu((int)Math.random()*20000);
        this.setBeneficiario("None");
    }
    public CuentaCorriente(CuentaCorriente c)
    {
        this.setSaldo(c.getSaldo());
        this.setCbu(c.getCbu());
        this.setBeneficiario(c.getBeneficiario());
    }

    public CuentaCorriente(int cbu, double saldo, String beneficiario)
    {
        this.setSaldo(saldo);
        this.setCbu(cbu);
        this.setBeneficiario(beneficiario);
    }

    private  void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public void setCbu(int cbu) {
        this.cbu = cbu;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Double getSaldo()
    {
        return saldo;
    }

    public String getBeneficiario()
    {
        return  beneficiario;
    }

    public int getCbu()
    {
        return cbu;
    }

    public void ingreso(int n)
    {
        saldo +=n;
    }
    public  void  egreso(int n)
    {
        if (this.getSaldo() - n >0)
        {
            saldo -=n;
        }
    }
    public  void reintegro(int valor, CuentaCorriente remitente)
    {
        remitente.egreso(valor);
        this.ingreso(valor);
    }
    public void transferencia(int valor, CuentaCorriente cuentadestino)
    {
        if (this.getSaldo()-valor > 0)
        {
            this.egreso(valor);
            cuentadestino.ingreso(valor);
        }
    }
}
