package com.globant.semisenior.business;

import com.globant.semisenior.entitities.ElementEntity;
import com.globant.semisenior.repositories.ElementRepo;
import com.globant.semisenior.rest.controller.DTO.SetupRequestDTO;
import com.globant.semisenior.rest.controller.DTO.SetupResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class SetupServiceImpl implements SetupService {

  private final ElementRepo elementRepo;

  public SetupServiceImpl(ElementRepo elementRepo) {
    this.elementRepo = elementRepo;
  }

  @Override
  public SetupResponseDTO create(SetupRequestDTO setupRequestDTO, String category) {
    elementRepo.save(buildElementEntity(setupRequestDTO));
    return null;
  }

  private ElementEntity buildElementEntity(SetupRequestDTO setupRequestDTO) {
    return ElementEntity.builder()
        .nombre(setupRequestDTO.getNameElement())
        .build();
  }
}
