package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /////////////////////EJERCICIO 1///////////////////
        Scanner scaner = new Scanner(System.in);
        System.out.println("Ingrese el numero de numeros pares que desea ver");
        int numPares = scaner.nextInt();
        ejercicio1(numPares);
        //////////////////////EJERCICIO2//////////////////
        System.out.println("ahora cacularemos los n multiplos de m");
        System.out.println("ingrese n");
        int n = scaner.nextInt();
        System.out.println("ingrese m");
        int m = scaner.nextInt();
        ejercicio2(n,m);
        ///////////////////////EJERCICIO 3 /////////////////
        System.out.println("Ahora ingrese el valor que desea saber si es numero primo");
        int numeroPrimo = scaner.nextInt();
        boolean esPrimo = ejercicio3(numeroPrimo);
        if (!esPrimo)
        {
            System.out.println("El numero no es primo");
        }
        else
        {
            System.out.println("El numero es primo");
        }
        ///////////////////////EJERCICIO 4 ///////////////////
        System.out.println("ahora ingrese la cantidad de numero primos que que quiere ver");
        int numeroDePrimos = scaner.nextInt();
        ejercicio4(numeroDePrimos);
        ///////////////////////EJERCICIO 5 ///////////////////
        System.out.println("ingrese la cantidad de numeros naturales");
        int cantidadDeNumeros = scaner.nextInt();
        System.out.println("ingrese la cantidad de digitos a buscar");
        int cantDigitos = scaner.nextInt();
        System.out.println("ingrese el digito a buscar");
        int digito = scaner.nextInt();
        ejercicio5(cantidadDeNumeros,cantDigitos,digito);
        scaner.close();
    }
    public static boolean esPar(int n)
    {
        return n%2 == 0;
    }

    public static boolean esMultiplo(int multiplo, int valor)
    {
        boolean result = false;
        if ( multiplo > valor)
        {
            result = multiplo%valor == 0;
        }
        else
        {
            result = valor%multiplo == 0;
        }
        return result;
    }
    public static int[] arraycopy(int[] firstArray, int[] secondArray)
    {
        int fal = firstArray.length;        //determines length of firstArray
        int sal = secondArray.length;   //determines length of secondArray
        int[] result = new int[fal + sal];  //resultant array of size first array and second array
        System.arraycopy(firstArray, 0, result, 0, fal);
        System.arraycopy(secondArray, 0, result, fal, sal);
        return result;
    }
    public static int[] recursion(int number) {
        int[] resultarray ={};
        if(number > 0) {
            resultarray = recursion(number/10);
            int[] innerarray = {number%10};
            return arraycopy(resultarray, innerarray);
        }else{
            return resultarray;
        }
    }
    public  static boolean hasDigits(int value, int cant, int digit)
    {
        String number = String.valueOf(value);
        int innercount =0;

        int[] digits1 = recursion(value);
        for(int i = 0; i < digits1.length; i++) {
            if(digits1[i] == digit)
            {
                innercount++;
            }
        }
        return innercount == cant;
    }
    public static void ejercicio5(int n, int m,int d)
    {
        int count =0;
        int i =0;
        while ( count < n)
        {
            if(hasDigits(i,m,d))
            {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }

    public static  void ejercicio4(int n)
    {
        int i = 1;
        int count = 0;
        while (count<n)
        {
            if(ejercicio3(i))
            {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
    public  static  boolean ejercicio3(int n)
    {
        int i =2;
        boolean isPrimary = true;
        while (i < n)
        {
            isPrimary = n%i != 0;
            if (!isPrimary)
            {
                break;
            }
            i++;
        }

        return isPrimary;

    }

    public static void ejercicio2(int n , int m)
    {
        int i =0;
        int count =0;
        while(count < n)
        {
            if(i>0 && esMultiplo(m,i))
            {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
    public static void ejercicio1(int n)
    {
        int count =0;
        int i =0;
        while(count < n )
        {
            if(esPar(i))
            {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}
