package com.brian.ejercicios.controller;

import com.brian.ejercicios.dto.DocumentoRequestDTO;
import com.brian.ejercicios.dto.DocumentoResponseDTO;
import com.brian.ejercicios.service.DocumentoService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    private final DocumentoService service;
    private final ObjectMapper objectMapper;

    public DocumentoController(DocumentoService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DocumentoResponseDTO subir(
            @RequestPart("archivo") MultipartFile archivo,
            @RequestPart("datos") String datosJson) throws IOException {

        DocumentoRequestDTO dto = objectMapper.readValue(datosJson, DocumentoRequestDTO.class);
        return service.guardar(archivo, dto);
    }

    @GetMapping
    public List<DocumentoResponseDTO> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public DocumentoResponseDTO obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
}
