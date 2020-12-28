package com.globant.semisenior.mappers;

import com.globant.semisenior.entitities.ContinentEntity;
import com.globant.semisenior.rest.controller.DTO.ContinentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = "spring")
public interface ContinentMapper {

  ContinentEntity continentDTOToContinentEntity(ContinentDTO continentDTO);

  ContinentDTO continentEntityToContinentDTO(ContinentEntity continentEntity);
}
