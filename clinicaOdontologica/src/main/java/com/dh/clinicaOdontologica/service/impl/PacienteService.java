package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.dh.clinicaOdontologica.repository.PacienteRepository;
import com.dh.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {
    private  PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteDTO cadastrarPac(PacienteDTO requestDTO) {
        Paciente paciente = toPaciente(requestDTO);
        Paciente pacienteCadastrado= pacienteRepository.save(paciente);
        PacienteDTO pacienteDTO = toPacienteDTO(pacienteCadastrado);

        return pacienteDTO;


    }

    @Override
    public void excluirPac(Long id) throws SQLException {

        pacienteRepository.deleteById(id);
    }

    public Optional<Paciente> buscarPorId(Long id) throws SQLException {
        return pacienteRepository.findById(id);
    }


    public Paciente toPaciente(PacienteDTO requestDTO) {
        return Paciente.builder()

                .nome(requestDTO.getNome())
                .rg(requestDTO.getRg())
                .endereco(requestDTO.getEndereco())
                .build();
    }

    private PacienteDTO toPacienteDTO(Paciente paciente) {
        return PacienteDTO.builder()

                .nome(paciente.getNome())
                .rg(paciente.getRg())
                .endereco(paciente.getEndereco())
                .build();
    }
}
