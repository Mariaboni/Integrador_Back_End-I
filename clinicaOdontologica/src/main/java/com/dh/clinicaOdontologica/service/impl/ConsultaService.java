package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.ConsultaDTO;
import com.dh.clinicaOdontologica.entity.Consulta;
import com.dh.clinicaOdontologica.exception.ResourceNotFoundException;
import com.dh.clinicaOdontologica.repository.ConsultaRepository;
import com.dh.clinicaOdontologica.repository.DentistaRepository;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.dh.clinicaOdontologica.service.IConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class ConsultaService implements IConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private DentistaRepository dentistaRepository;

    public ConsultaDTO cadastrarCons(ConsultaDTO requestDTO) throws SQLException, ResourceNotFoundException {
        if (pacienteRepository.findByRg(requestDTO.getRgPaciente()) != null && dentistaRepository.findByMatricula(requestDTO.getMatriculaDentista()) != null) {


            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            Consulta consulta = mapper.convertValue(requestDTO, Consulta.class);
            Consulta consultaCadastrada = consultaRepository.save(consulta);

            ConsultaDTO consultaDTO = mapper.convertValue(consultaCadastrada, ConsultaDTO.class);


            return consultaDTO;
        }else{
            throw new ResourceNotFoundException("Dentista ou Paciente não cadastrados.");
        }
    }

    /*public Consulta modificar(Consulta consulta) throws SQLException {
        return
    }*/

    @Override
    public Optional<Consulta> buscarPorId(Long id) throws SQLException {
        return consultaRepository.findById(id);
    }


}
