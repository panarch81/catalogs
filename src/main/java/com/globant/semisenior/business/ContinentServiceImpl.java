package com.globant.semisenior.business;

import antlr.StringUtils;
import com.globant.exceptions.ServiceException;
import com.globant.semisenior.entitities.CityEntity;
import com.globant.semisenior.entitities.ContinentEntity;
import com.globant.semisenior.entitities.CountryEntity;
import com.globant.semisenior.mappers.ContinentMapper;
import com.globant.semisenior.repositories.CityRepo;
import com.globant.semisenior.repositories.ContinentRepo;
import com.globant.semisenior.repositories.CountryRepo;
import com.globant.semisenior.rest.controller.DTO.ContinentDTO;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContinentServiceImpl implements ContinentService {

  private static final String COUNTRY_ALREADY_EXIST = "The country already exists";
  private final ContinentRepo continentRepo;
  private final CountryRepo countryRepo;
  private final CityRepo cityRepo;
  private final ContinentMapper continentMapper;


  public ContinentServiceImpl(
      ContinentRepo continentRepo,
      CountryRepo countryRepo,
      CityRepo cityRepo,
      ContinentMapper continentMapper) {
    this.continentRepo = continentRepo;
    this.countryRepo = countryRepo;
    this.cityRepo = cityRepo;
    this.continentMapper = continentMapper;
  }

  @Override
  public ContinentDTO create(ContinentDTO continentDTO){

    validateIsNewContinent(continentDTO);

    ContinentEntity continentEntity = continentMapper.continentDTOToContinentEntity(continentDTO);

    continentEntity.getCountries()
        .stream()
        .forEach( countryEntity ->
        {
          countryEntity.setContinent(continentEntity);
          countryEntity.getCities()
              .stream()
              .forEach( cityEntity ->
                  cityEntity.setCountry(countryEntity));

        });

    return continentMapper.continentEntityToContinentDTO(continentRepo.save(continentEntity));
  }

  @Override
  public ContinentDTO getContinent(Long idContinent) {
    ContinentEntity continentEntity = continentRepo.getOne(idContinent);
    return continentMapper.continentEntityToContinentDTO(continentEntity);
  }

  private void validateIsNewContinent(ContinentDTO continentDTO) {
    if(Objects.nonNull(continentDTO.getName())){
      Optional<ContinentEntity> existingCountry = continentRepo.findByName(continentDTO.getName());
      if(existingCountry.isPresent()){
        throw new ServiceException(HttpStatus.BAD_REQUEST.value(), COUNTRY_ALREADY_EXIST);
      }
    }

  }
}
