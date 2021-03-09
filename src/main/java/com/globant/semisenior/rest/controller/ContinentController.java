package com.globant.semisenior.rest.controller;

import com.globant.semisenior.business.ContinentService;
import com.globant.semisenior.rest.controller.DTO.ContinentDTO;
import com.globant.semisenior.rest.controller.interfaces.ContinentOperations;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class ContinentController implements ContinentOperations {
  private final ContinentService continentService;

  @Override
  public ResponseEntity<ContinentDTO> create(final ContinentDTO continent) {
    return ResponseEntity.ok(continentService.create(continent));
  }

  @Override
  public ResponseEntity<ContinentDTO> getContinent(Long continentId) {
    return ResponseEntity.ok(continentService.getContinent(continentId));
  }

  @Override
  public ResponseEntity<ContinentDTO> updateContinent(ContinentDTO continent) {
    return ResponseEntity.ok(continentService.update(continent));
  }


}
