package com.teamorange.fipapi.services;

import com.teamorange.fipapi.domain.Usuario;
import com.teamorange.fipapi.domain.model.UsuarioDTO;
import com.teamorange.fipapi.exceptions.ResourceNotFoundException;
import com.teamorange.fipapi.repositories.UsuarioRepository;
import com.teamorange.fipapi.utils.mappers.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO insert (UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioMapper.frommDtoToEntity(usuarioDTO);
        Usuario usuarioPers = usuarioRepository.save(usuario);
        return usuarioMapper.fromEntityToDto(usuarioPers);
    }

    public UsuarioDTO findById(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Objeto não encontrado"));
        return usuarioMapper.fromEntityToDto(usuario);
    }
}
