package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.request.DentistaRequestDTO;
import com.dh.clinicaOdontologica.dto.response.DentistaResponseDTO;
import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.service.impl.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {
@Autowired
    private DentistaService dentistaService;


    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }


    @PostMapping
    public ResponseEntity<DentistaResponseDTO> cadastrarDentista(@RequestBody DentistaRequestDTO dentista) throws SQLException {
        DentistaResponseDTO response = dentistaService.cadastrarDentista(dentista);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/buscar")
    public List<Dentista> buscarDentistas() throws SQLException {
        return dentistaService.buscarTodos();
    }

}
