package com.brian.ejercicios.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "documentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

    @Column(name = "ruta_archivo")
    private String rutaArchivo;

    @Column(name = "tamanio_archivo")
    private Long tamanioArchivo;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    // Relación muchos a muchos con Usuario (autorizadores)
    @ManyToMany
    @JoinTable(
        name = "documento_autorizadores",
        joinColumns = @JoinColumn(name = "documento_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> autorizadores;

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }
}
