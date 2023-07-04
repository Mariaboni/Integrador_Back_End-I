package com.dh.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor@Builder
@JsonIgnoreProperties (ignoreUnknown = true)
public class ConsultaDTO {

    @NotBlank
    private String rgPaciente;
    @NotNull
    private int matriculaDentista;

    private LocalDateTime dataConsulta;
}

