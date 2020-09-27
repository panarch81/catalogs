package com.globant.semisenior.rest.controller;

import com.globant.semisenior.business.SetupService;
import com.globant.semisenior.rest.controller.DTO.SetupRequestDTO;
import com.globant.semisenior.rest.controller.DTO.SetupResponseDTO;
import com.globant.semisenior.rest.controller.interfaces.SetupOperations;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class SetupController implements SetupOperations {
  private final SetupService setupService;



  @Override
  public ResponseEntity<SetupResponseDTO> create(String productNameCategory, final SetupRequestDTO setupRequestDTO) {

    return ResponseEntity.ok(setupService.create(setupRequestDTO, productNameCategory));
  }
}
