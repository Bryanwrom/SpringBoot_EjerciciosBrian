package com.brian.ejercicios.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DocumentoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String tipoDocumento;
    private String nombreArchivo;
    private Long tamanioArchivo;
    private LocalDateTime fechaRegistro;
    private List<UsuarioSimpleDTO> autorizadores;

    @Data
    public static class UsuarioSimpleDTO {
        private Long id;
        private String nombre;
        private String email;
    }
}
