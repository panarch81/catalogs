package com.globant.semisenior.business;

import com.globant.semisenior.rest.controller.DTO.ContinentDTO;

public interface ContinentService {

  ContinentDTO create(ContinentDTO continentDTO);

  ContinentDTO getContinent(Long idContinent);

  ContinentDTO update(ContinentDTO continentDTO);
}
