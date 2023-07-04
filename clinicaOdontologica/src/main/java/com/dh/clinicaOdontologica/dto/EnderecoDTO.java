package com.dh.clinicaOdontologica.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO {


    private String rua;
    private int numero;
    private String cidade;
    private String estado;

}
