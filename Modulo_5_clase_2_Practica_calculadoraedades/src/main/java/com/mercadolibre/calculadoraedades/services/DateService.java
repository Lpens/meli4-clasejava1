package com.mercadolibre.calculadoraedades.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateService {
    public static double GetEdad(int day, int month, int year)
    {
        LocalDate date = LocalDate.of(year, month,day);
        LocalDate now = LocalDate.now();

        return ChronoUnit.YEARS.between(date, now);

    }
}
