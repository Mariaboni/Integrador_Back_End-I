package com.dh.clinicaOdontologica.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor@Builder
@JsonIgnoreProperties (ignoreUnknown = true)
public class DentistaRequestDTO {


    private String nome;

    private int matricula;
}
