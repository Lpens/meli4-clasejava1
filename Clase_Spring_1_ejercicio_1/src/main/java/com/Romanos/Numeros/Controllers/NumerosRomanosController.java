package com.Romanos.Numeros.Controllers;

import com.Romanos.Numeros.Entity.NumeroRomano;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/numerosapi")
public class NumerosRomanosController {
    private  final AtomicLong counter = new AtomicLong();
    @GetMapping("/toRoman/{numero}")
    public NumeroRomano toRoman(@PathVariable int numero, HttpServletResponse response)
    {
        if(numero > 3999) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return new NumeroRomano(counter.incrementAndGet(), numero);
    }
}
