package com.brian.ejercicios.dto;

import lombok.Data;
import java.util.List;

@Data
public class DocumentoRequestDTO {

    private String nombre;
    private String descripcion;
    private String tipoDocumento;
    private List<Long> autorizadoresIds;
}
