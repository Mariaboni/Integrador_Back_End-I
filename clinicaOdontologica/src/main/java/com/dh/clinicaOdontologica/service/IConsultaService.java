package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.ConsultaDTO;
import com.dh.clinicaOdontologica.entity.Consulta;
import com.dh.clinicaOdontologica.exception.ResourceNotFoundException;


import java.sql.SQLException;
import java.util.Optional;

public interface IConsultaService {
    ConsultaDTO cadastrarCons(ConsultaDTO consultaDTO) throws SQLException, ResourceNotFoundException;

    Optional<Consulta> buscarPorId(Long id) throws SQLException;
}
