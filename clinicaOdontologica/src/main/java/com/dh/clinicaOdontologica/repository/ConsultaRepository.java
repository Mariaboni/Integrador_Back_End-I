package com.dh.clinicaOdontologica.repository;

import com.dh.clinicaOdontologica.dto.ConsultaDTO;
import com.dh.clinicaOdontologica.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByDentistaId(Long dentistaId);
    List<Consulta> findByPacienteId(Long pacienteId);





}
