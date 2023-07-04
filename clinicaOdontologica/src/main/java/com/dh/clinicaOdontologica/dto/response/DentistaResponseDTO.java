package com.dh.clinicaOdontologica.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistaResponseDTO {


    private String nome;
    private int matricula;




}
