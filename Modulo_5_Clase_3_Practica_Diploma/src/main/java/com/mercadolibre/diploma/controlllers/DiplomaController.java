package com.mercadolibre.diploma.controlllers;

import com.mercadolibre.diploma.Services.DiplomaService;
import com.mercadolibre.diploma.entity.AlumnoDTO;
import com.mercadolibre.diploma.entity.DiplomaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class DiplomaController {

    @PostMapping("/diploma")
    public ResponseEntity getDiploma(@RequestBody AlumnoDTO alumno)
    {
        try {
            DiplomaDTO diploma = DiplomaService.getDiploma(alumno);
            return new ResponseEntity(diploma, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
