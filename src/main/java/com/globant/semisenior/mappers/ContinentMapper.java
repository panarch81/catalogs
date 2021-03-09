package com.globant.semisenior.mappers;

import com.globant.semisenior.entitities.ContinentEntity;
import com.globant.semisenior.entitities.CountryEntity;
import com.globant.semisenior.repositories.ContinentRepo;
import com.globant.semisenior.rest.controller.DTO.ContinentDTO;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = "spring")
public interface ContinentMapper {

  ContinentEntity continentDTOToContinentEntity(ContinentDTO continentDTO);

  ContinentDTO continentEntityToContinentDTO(ContinentEntity continentEntity);

  /*ContinentEntity mergeContinentEntities(@MappingTarget ContinentEntity currentContinentEntity,
      ContinentEntity continentEntity);*/

  default ContinentEntity mergeContinentEntities(@MappingTarget ContinentEntity currentContinentEntity,
      ContinentEntity continentEntity) {

    List<String> currentCountryNames = currentContinentEntity.getCountries().stream().map(
        CountryEntity::getName)
        .collect( Collectors.toList());

    List<String> newCountryNames = continentEntity.getCountries().stream().map(
        CountryEntity::getName)
        .collect( Collectors.toList());

        continentEntity.getCountries()
            .stream()
            .forEach( countryEntity -> {
              if(!currentCountryNames.contains(countryEntity.getName())){
                countryEntity.setContinent(currentContinentEntity);
                currentContinentEntity.getCountries().add(countryEntity);
              }
        } );

      return currentContinentEntity;

  }
}
