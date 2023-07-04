package com.dh.clinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="dentista_id")
    private Dentista dentista;
    @OneToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @Column(nullable = false)
    private LocalDateTime dataConsulta;


}
