package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.entity.Endereco;
import com.dh.clinicaOdontologica.repository.EnderecoRepository;
import com.dh.clinicaOdontologica.service.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class EnderecoService implements IEnderecoService {

    private  EnderecoRepository enderecoRepository;

 @Autowired
    private EnderecoService(EnderecoRepository enderecoRepository){this.enderecoRepository = enderecoRepository;}



    @Override
    public EnderecoDTO cadastrarEnd(EnderecoDTO requestDTO) throws SQLException {
        Endereco endereco = toEndereco(requestDTO);
        Endereco enderecoCadastrado= enderecoRepository.save(endereco);
       EnderecoDTO enderecoDTO = toEnderecoDTO(enderecoCadastrado);

        return enderecoDTO;
    }

    public void excluirEnd(Long id) throws SQLException {
        enderecoRepository.deleteById(id);
    }

    @Override
    public Optional<Endereco> buscarPorId(Long id) throws SQLException {
        return enderecoRepository.findById(id);
    }



    public Endereco toEndereco(EnderecoDTO requestDTO) {
        return Endereco.builder()

                .rua(requestDTO.getRua())
                .numero(requestDTO.getNumero())
                .cidade(requestDTO.getCidade())
                .estado(requestDTO.getEstado())
                .build();
    }

    private EnderecoDTO toEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()

                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .numero(endereco.getNumero())
                .rua(endereco.getRua())
                .build();
    }

}

