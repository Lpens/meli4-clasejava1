package com.mercadolibre.diploma.Services;

import com.mercadolibre.diploma.entity.AlumnoDTO;
import com.mercadolibre.diploma.entity.AsignaturaDTO;
import com.mercadolibre.diploma.entity.DiplomaDTO;

public class DiplomaService {
    private static String successMessage = "felicitaciones tu promedio es mayor a 9!";

    public static DiplomaDTO getDiploma(AlumnoDTO alumno)
    {
        double promedio =0;
        for (AsignaturaDTO asignatura : alumno.getAsignaturas())
        {
            promedio += asignatura.getNota();
        }
        promedio = promedio / alumno.getAsignaturas().size();

        DiplomaDTO diploma = new DiplomaDTO();
        diploma.setPromedio(promedio);
        diploma.setAlumno(alumno);
        diploma.setMensaje(promedio > 9 ? successMessage : "");
        
        return diploma;
    }
}
