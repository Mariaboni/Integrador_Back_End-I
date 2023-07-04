package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.ConsultaDTO;
import com.dh.clinicaOdontologica.entity.Consulta;
import com.dh.clinicaOdontologica.exception.Exceptions;
import com.dh.clinicaOdontologica.service.impl.ConsultaService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;
@RestController("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;


    @PostMapping("/cadastrarCons")
    public ResponseEntity cadastrarCons(@RequestBody ConsultaDTO consultaDTO) throws Exceptions {
        try{
            ConsultaDTO consultaCadastrada = consultaService.cadastrarCons(consultaDTO);
            return new ResponseEntity("Paciente foi cadastrado no dia: " + consultaCadastrada.getDataConsulta(), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exceptions("Erro ao cadastrar consulta");
        }
    }



}
