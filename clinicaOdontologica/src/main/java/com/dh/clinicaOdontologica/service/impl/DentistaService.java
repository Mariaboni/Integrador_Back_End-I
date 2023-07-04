package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.request.DentistaRequestDTO;
import com.dh.clinicaOdontologica.dto.response.DentistaResponseDTO;
import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.repository.DentistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DentistaService {
 @Autowired
    private DentistaRepository dentistaRepository;




    public DentistaResponseDTO cadastrarDentista(DentistaRequestDTO requestDTO) throws SQLException {

        ObjectMapper mapper = new ObjectMapper();
        Dentista dentista = mapper.convertValue(requestDTO, Dentista.class);
        Dentista dentistaCadastrado = dentistaRepository.save(dentista);

        DentistaResponseDTO dentistaResponseDTO = mapper.convertValue(dentistaCadastrado, DentistaResponseDTO.class);


        return dentistaResponseDTO ;
    }

    public List<Dentista> buscarTodos() throws SQLException {
        return dentistaRepository.findAll();
    }

}
