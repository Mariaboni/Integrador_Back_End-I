package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.entity.Paciente;

import java.sql.SQLException;
import java.util.Optional;


public interface IPacienteService {

    PacienteDTO cadastrarPac(PacienteDTO pacienteDTO) throws SQLException;

    public void excluirPac(Long id) throws  SQLException;


    Optional<Paciente> buscarPorId(Long id) throws SQLException;
}

