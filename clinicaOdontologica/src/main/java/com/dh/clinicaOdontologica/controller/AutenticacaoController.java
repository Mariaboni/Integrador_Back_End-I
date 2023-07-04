package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.security.TokenDTO;
import com.dh.clinicaOdontologica.dto.UsuarioLoginDTO;
import com.dh.clinicaOdontologica.dto.UsuarioDTO;
import com.dh.clinicaOdontologica.entity.Usuario;
import com.dh.clinicaOdontologica.security.*;
import com.dh.clinicaOdontologica.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity logar(@RequestBody UsuarioLoginDTO usuarioLoginDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(usuarioLoginDto.getLogin(), usuarioLoginDto.getSenha());
        Authentication authenticate = manager.authenticate(authenticationToken);
        String tokenJwt = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(tokenJwt));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuarioRequestDto));
    }

}
