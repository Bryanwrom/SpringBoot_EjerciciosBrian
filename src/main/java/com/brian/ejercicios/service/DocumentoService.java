package com.brian.ejercicios.service;

import com.brian.ejercicios.dto.DocumentoRequestDTO;
import com.brian.ejercicios.dto.DocumentoResponseDTO;
import com.brian.ejercicios.entity.Documento;
import com.brian.ejercicios.entity.Usuario;
import com.brian.ejercicios.repository.DocumentoRepository;
import com.brian.ejercicios.repository.UsuarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final UsuarioRepository usuarioRepository;

    private final String UPLOAD_DIR = "archivos/";

    public DocumentoService(DocumentoRepository documentoRepository,
                            UsuarioRepository usuarioRepository) {
        this.documentoRepository = documentoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public DocumentoResponseDTO guardar(MultipartFile archivo,
                                        DocumentoRequestDTO dto) throws IOException {

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String nombreArchivo = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();
        Path rutaArchivo = uploadPath.resolve(nombreArchivo);
        Files.copy(archivo.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

        List<Usuario> autorizadores = usuarioRepository.findAllById(dto.getAutorizadoresIds());

        Documento documento = new Documento();
        documento.setNombre(dto.getNombre());
        documento.setDescripcion(dto.getDescripcion());
        documento.setTipoDocumento(dto.getTipoDocumento());
        documento.setNombreArchivo(archivo.getOriginalFilename());
        documento.setRutaArchivo(rutaArchivo.toString());
        documento.setTamanioArchivo(archivo.getSize());
        documento.setAutorizadores(autorizadores);

        Documento guardado = documentoRepository.save(documento);

        return toDTO(guardado);
    }

    public List<DocumentoResponseDTO> obtenerTodos() {
        return documentoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public DocumentoResponseDTO obtenerPorId(Long id) {
        Documento doc = documentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));
        return toDTO(doc);
    }

    private DocumentoResponseDTO toDTO(Documento doc) {
        DocumentoResponseDTO dto = new DocumentoResponseDTO();
        dto.setId(doc.getId());
        dto.setNombre(doc.getNombre());
        dto.setDescripcion(doc.getDescripcion());
        dto.setTipoDocumento(doc.getTipoDocumento());
        dto.setNombreArchivo(doc.getNombreArchivo());
        dto.setTamanioArchivo(doc.getTamanioArchivo());
        dto.setFechaRegistro(doc.getFechaRegistro());

        List<DocumentoResponseDTO.UsuarioSimpleDTO> autorizadores = doc.getAutorizadores()
                .stream()
                .map(u -> {
                    DocumentoResponseDTO.UsuarioSimpleDTO uDTO = new DocumentoResponseDTO.UsuarioSimpleDTO();
                    uDTO.setId(u.getId());
                    uDTO.setNombre(u.getNombre());
                    uDTO.setEmail(u.getEmail());
                    return uDTO;
                })
                .toList();

        dto.setAutorizadores(autorizadores);
        return dto;
    }
}
