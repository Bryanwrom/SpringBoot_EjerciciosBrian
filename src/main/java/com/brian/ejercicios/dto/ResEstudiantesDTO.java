package com.brian.ejercicios.dto;

import java.util.List;

public class ResEstudiantesDTO {

    private Integer codigoEstatus;
    private String mensaje;
    private List<EstudianteDTO> estudiantes;

    public ResEstudiantesDTO() {
    }

    public ResEstudiantesDTO(
            Integer codigoEstatus,
            String mensaje,
            List<EstudianteDTO> estudiantes) {

        this.codigoEstatus = codigoEstatus;
        this.mensaje = mensaje;
        this.estudiantes = estudiantes;
    }

    public Integer getCodigoEstatus() {
        return codigoEstatus;
    }

    public void setCodigoEstatus(Integer codigoEstatus) {
        this.codigoEstatus = codigoEstatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }
}