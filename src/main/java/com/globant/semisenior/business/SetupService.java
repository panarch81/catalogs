package com.globant.semisenior.business;

import com.globant.semisenior.rest.controller.DTO.SetupRequestDTO;
import com.globant.semisenior.rest.controller.DTO.SetupResponseDTO;

public interface SetupService {

  SetupResponseDTO create(SetupRequestDTO setupRequestDTO, String category);

}
