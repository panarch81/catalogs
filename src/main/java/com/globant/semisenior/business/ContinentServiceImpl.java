package com.globant.semisenior.business;

import com.globant.semisenior.entitities.ContinentEntity;
import com.globant.semisenior.mappers.ContinentMapper;
import com.globant.semisenior.repositories.CityRepo;
import com.globant.semisenior.repositories.ContinentRepo;
import com.globant.semisenior.repositories.CountryRepo;
import com.globant.semisenior.rest.controller.DTO.ContinentDTO;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class ContinentServiceImpl implements ContinentService {

  private static final String COUNTRY_ALREADY_EXIST = "The country already exists";
  private static final String CONTINENT_NOT_EXIST = "Continent not exist to be updated";
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

    if(!validateIsNewContinent(continentDTO)){
      throw new ServiceException(COUNTRY_ALREADY_EXIST);
    }

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
    Optional<ContinentEntity> continentEntity = continentRepo.findById(idContinent);
    if(continentEntity.isPresent()){
      return continentMapper.continentEntityToContinentDTO(continentEntity.get());
    }
    return null;
  }

  @Override
  public ContinentDTO update(ContinentDTO continentDTO) {
    ContinentEntity mergedContinent = null;

    if(validateIsNewContinent(continentDTO)){
      throw new ServiceException(CONTINENT_NOT_EXIST);
    }
    //merge the current with the new one
    Optional<ContinentEntity> existingContinent = continentRepo.findByName(continentDTO.getName());

    if(existingContinent.isPresent()){
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

      ContinentEntity currentContinentEntity = existingContinent.get();

      //arreglar el merge, para que no pise si no que agregue
      mergedContinent = continentMapper.mergeContinentEntities( existingContinent.get(),
          continentEntity);

      /*mergedContinent = continentMapper.mergeContinentEntities(existingContinent.get(),
          continentEntity);*/

    }
    //ContinentEntity updatedContinent = continentRepo.update( mergedContinent );
    continentRepo.save(mergedContinent);
    return continentMapper.continentEntityToContinentDTO(mergedContinent);
  }

  private boolean validateIsNewContinent(ContinentDTO continentDTO) {
    if(Objects.nonNull(continentDTO.getName())){
      Optional<ContinentEntity> existingContinent = continentRepo.findByName(continentDTO.getName());
      if(existingContinent.isPresent()){
        return false;
      }
      return true;
    }
    return false;
  }
}
