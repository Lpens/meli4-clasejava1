package com.mercadolibre.linktracker.exceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException()
    {
        super("Wrong Password Provided.");
    }
}
