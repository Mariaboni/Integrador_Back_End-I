package com.dh.clinicaOdontologica.service.impl;

import com.dh.clinicaOdontologica.dto.UsuarioDTO;
import com.dh.clinicaOdontologica.entity.Usuario;
import com.dh.clinicaOdontologica.repository.UsuarioRepository;
import com.dh.clinicaOdontologica.service.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO requestDto) {
        ObjectMapper mapper = new ObjectMapper();
        Usuario usuarioEntity = mapper.convertValue(requestDto, Usuario.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode(usuarioEntity.getSenha());
        usuarioEntity.setSenha(senhaCriptografada);
        Usuario usuarioSalvo = usuarioRepository.save(usuarioEntity);
        UsuarioDTO usuarioDTO = mapper.convertValue(usuarioSalvo, UsuarioDTO.class);
        return usuarioDTO;
    }
}
