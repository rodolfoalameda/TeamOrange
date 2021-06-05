package com.teamorange.fipapi.utils.mappers;

import com.teamorange.fipapi.domain.Veiculo;
import com.teamorange.fipapi.domain.model.VeiculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    @Mapping(target = "idUsuario", source = "usuario.id")
    VeiculoDTO fromEntityToDto (Veiculo veiculo);

    @Mapping(target = "usuario.id", source = "idUsuario")
    Veiculo frommDtoToEntity(VeiculoDTO veiculoDTO);
}
