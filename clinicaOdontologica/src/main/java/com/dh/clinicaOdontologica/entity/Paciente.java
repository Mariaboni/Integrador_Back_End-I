package com.dh.clinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;


    @Column(name = "rg")
    private String rg;

    @OneToOne(mappedBy = "paciente")
    private Consulta consulta;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;



}
