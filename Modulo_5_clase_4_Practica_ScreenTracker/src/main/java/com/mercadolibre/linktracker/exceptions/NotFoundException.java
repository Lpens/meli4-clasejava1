package com.mercadolibre.linktracker.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException(String linkId)
    {
        super(linkId);
    }
}
