package com.dh.clinicaOdontologica.dto;

import com.dh.clinicaOdontologica.security.UsuarioRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {

    private String login;

    private String senha;

    private UsuarioRole usuarioRole;
}

