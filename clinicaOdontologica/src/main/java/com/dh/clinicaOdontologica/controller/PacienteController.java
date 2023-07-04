package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.exception.Exceptions;
import com.dh.clinicaOdontologica.exception.ResourceNotFoundException;
import com.dh.clinicaOdontologica.service.impl.EnderecoService;
import com.dh.clinicaOdontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Objects;
@RequestMapping("/paciente")
@RestController
public class PacienteController {

    PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) throws SQLException {
        Paciente paciente = pacienteService.buscarPorId(id).orElse(null);
        if (Objects.nonNull(paciente)) {
            return ResponseEntity.status(HttpStatus.OK).body(paciente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrarPac(@RequestBody PacienteDTO pacienteDTO) throws Exceptions {
        try{
            PacienteDTO pacienteCadastrado = pacienteService.cadastrarPac(pacienteDTO);
            return new ResponseEntity("Paciente " + pacienteCadastrado.getNome() + " foi cadastrado", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exceptions("Erro ao cadastrar o paciente");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPac(@PathVariable Long id) throws SQLException {
        Paciente paciente = pacienteService.buscarPorId(id).orElse(null);
        if (Objects.nonNull(paciente)) {
            pacienteService.excluirPac(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}

