package com.teamorange.fipapi.utils.mappers;

import com.teamorange.fipapi.domain.Usuario;
import com.teamorange.fipapi.domain.model.UsuarioDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {VeiculoMapper.class})
public interface UsuarioMapper {

    Usuario frommDtoToEntity (UsuarioDTO usuarioDTO);
    UsuarioDTO fromEntityToDto (Usuario usuario);
}
