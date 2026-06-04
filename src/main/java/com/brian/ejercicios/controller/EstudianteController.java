package com.brian.ejercicios.controller;

import com.brian.ejercicios.dto.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @GetMapping
    public ResEstudiantesDTO obtenerEstudiantes() {

        List<EstudianteDTO> estudiantes = List.of(

            new EstudianteDTO(
                2026001,
                "Antonio Montes",
                "antonio@gmail.com",
                new DireccionDTO(
                    "Av. Central",
                    "Las Americas",
                    "Ecatepec"
                ),
                "5512345678"
            ),

            new EstudianteDTO(
                2026002,
                "Oscar Lopez",
                "oscar@gmail.com",
                new DireccionDTO(
                    "Av. Reforma",
                    "Centro",
                    "Ciudad de Mexico"
                ),
                "5587654321"
            ),

            new EstudianteDTO(
                2026003,
                "Elizabeth Garcia",
                "elizabeth@gmail.com",
                new DireccionDTO(
                    "Calle 5 de Mayo",
                    "Roma",
                    "Guadalajara"
                ),
                "5555555555"
            )
        );

        return new ResEstudiantesDTO(
            200,
            "Consulta exitosa",
            estudiantes
        );
    }
}