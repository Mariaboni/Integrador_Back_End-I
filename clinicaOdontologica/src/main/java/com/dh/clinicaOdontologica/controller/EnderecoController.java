package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.exception.Exceptions;
import com.dh.clinicaOdontologica.service.impl.EnderecoService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Objects;

@RestController
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/cadastrarEnd")
    public ResponseEntity<EnderecoDTO> cadastrarEnd(@RequestBody EnderecoDTO enderecoDTO) throws Exceptions {
        try {
            EnderecoDTO enderecoCadastrado = enderecoService.cadastrarEnd(enderecoDTO);
            return new ResponseEntity("O Endereco foi cadastrado", HttpStatus.CREATED);
        }catch (Exception e) {
            throw new Exceptions("Endereço não cadastrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Long id) throws SQLException {
        Endereco endereco = enderecoService.buscarPorId(id).orElse(null);
        if (Objects.nonNull(endereco)) {
            enderecoService.excluirEnd(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    }




