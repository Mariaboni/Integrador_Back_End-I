package com.dh.clinicaOdontologica.dto;

import com.dh.clinicaOdontologica.entity.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private String nome;
    private String rg;
    private Endereco endereco;
}
