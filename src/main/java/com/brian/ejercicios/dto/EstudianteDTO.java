package com.brian.ejercicios.dto;

public class EstudianteDTO {

    private Integer numeroControl;
    private String nombre;
    private String email;
    private DireccionDTO direccion;
    private String telefono;

    public EstudianteDTO() {
    }

    public EstudianteDTO(Integer numeroControl,
                         String nombre,
                         String email,
                         DireccionDTO direccion,
                         String telefono) {

        this.numeroControl = numeroControl;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(Integer numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}