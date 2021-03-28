package com.Romanos.Numeros.Entity;

import lombok.Data;

@Data
public class NumeroRomano{
    private long id;
    private String valorRomano;
    private int valorDecimal;

    public NumeroRomano (Long id, int decimal)
    {
        this.id = id;
        this.valorDecimal = decimal;
        this.valorRomano = "";
        this.calculateRoman();
    }
    public void calculateRoman()
    {
        int millar = (this.valorDecimal/1000) % 10;
        int centena = (this.valorDecimal/100) %10;
        int decena = (this.valorDecimal/10) %10;
        int unidades = (this.valorDecimal/1) %10;

        if(millar > 3)
        {
            this.valorRomano = "el numero no se puede representar";
        }
        else{

            this.valorRomano+=this.getMillarRomanNumber(millar) +
                    this.getHundredRomanNumber(centena)
                    + this.getTenthRomanNumber(decena)
                    + this.getUnitRomanNumber(unidades);
        }
    }

    public String getMillarRomanNumber(int n)
    {
        String valorMillar="";
        for ( int i = 0; i<n; i++)
        {
            valorMillar += "M";
        }
        return  valorMillar;
    }
    public String getHundredRomanNumber(int n)
    {
        String valorCentena = "";
        switch (n)
        {
            case 1:
                valorCentena = "C";
                break;
            case 2:
                valorCentena = "CC";
                break;
            case 3:
                valorCentena = "CCC";
                break;
            case 4:
                valorCentena = "CD";
                break;
            case 5:
                valorCentena = "D";
                break;
            case 6:
                valorCentena = "DC";
                break;
            case 7:
                valorCentena = "DCC";
                break;
            case 8:
                valorCentena = "DCCC";
                break;
            case 9:
                valorCentena = "CM";
                break;
        }
        return valorCentena;
    }

    public String getTenthRomanNumber(int n)
    {
        String valorDecena = "";
        switch (n)
        {
            case 1:
                valorDecena = "X";
                break;
            case 2:
                valorDecena = "XX";
                break;
            case 3:
                valorDecena = "XXX";
                break;
            case 4:
                valorDecena = "XL";
                break;
            case 5:
                valorDecena = "L";
                break;
            case 6:
                valorDecena = "LX";
                break;
            case 7:
                valorDecena = "LXX";
                break;
            case 8:
                valorDecena = "LXXX";
                break;
            case 9:
                valorDecena = "XC";
                break;
        }
        return valorDecena;
    }

    public String getUnitRomanNumber(int n)
    {
        String valorUnidad = "";
        switch (n)
        {
            case 1:
                valorUnidad = "I";
                break;
            case 2:
                valorUnidad = "II";
                break;
            case 3:
                valorUnidad = "III";
                break;
            case 4:
                valorUnidad = "IV";
                break;
            case 5:
                valorUnidad = "V";
                break;
            case 6:
                valorUnidad = "VI";
                break;
            case 7:
                valorUnidad = "VII";
                break;
            case 8:
                valorUnidad = "VIII";
                break;
            case 9:
                valorUnidad = "IX";
                break;
        }
        return valorUnidad;
    }
}
