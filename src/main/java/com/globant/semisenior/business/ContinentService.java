package com.globant.semisenior.business;

import com.globant.semisenior.rest.controller.DTO.ContinentDTO;
import org.springframework.http.ResponseEntity;

public interface ContinentService {

  ContinentDTO create(ContinentDTO continentDTO);

  ContinentDTO getContinent(Long idContinent);

}
