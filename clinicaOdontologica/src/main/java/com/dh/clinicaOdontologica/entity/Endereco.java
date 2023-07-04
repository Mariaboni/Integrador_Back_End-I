package com.dh.clinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "rua")
    private String rua;

    @Column(name = "num")
    private int numero;

    @Column(name = "cidade")
    private String cidade;


    @Column(name = "estado")
    private String estado;
}

