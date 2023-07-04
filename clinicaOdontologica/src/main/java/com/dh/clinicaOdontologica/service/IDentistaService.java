package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.entity.Dentista;

import java.sql.SQLException;
import java.util.List;

public interface IDentistaService {

 Dentista cadastrarDentista(Dentista dentista) throws SQLException;

    List<Dentista> buscarTodos() throws SQLException;
}
