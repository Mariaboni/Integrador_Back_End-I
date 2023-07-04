package com.dh.clinicaOdontologica.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity@Table(name = "Dentista")
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private int matricula;

    @OneToOne(mappedBy = "dentista")
    private Consulta consulta;

}
