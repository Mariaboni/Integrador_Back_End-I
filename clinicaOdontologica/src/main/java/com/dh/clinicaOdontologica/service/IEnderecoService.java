package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.EnderecoDTO;
import com.dh.clinicaOdontologica.entity.Endereco;


import java.sql.SQLException;
import java.util.Optional;


public interface IEnderecoService {

  EnderecoDTO cadastrarEnd(EnderecoDTO enderecoDTO) throws SQLException;

  public void excluirEnd(Long id) throws SQLException;

  Optional<Endereco> buscarPorId(Long id) throws SQLException;
}
