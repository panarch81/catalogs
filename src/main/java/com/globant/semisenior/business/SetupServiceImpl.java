package com.globant.semisenior.business;

import com.globant.semisenior.entitities.ElementEntity;
import com.globant.semisenior.repositories.ElementRepo;
import com.globant.semisenior.rest.controller.DTO.SetupRequestDTO;
import com.globant.semisenior.rest.controller.DTO.SetupResponseDTO;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class SetupServiceImpl implements SetupService {

  private final ElementRepo elementRepo;

  public SetupServiceImpl(ElementRepo elementRepo) {
    this.elementRepo = elementRepo;
  }

  @Override
  public SetupResponseDTO create(SetupRequestDTO setupRequestDTO, String category) {
    ElementEntity parentEntity = buildElementEntity(setupRequestDTO);
    elementRepo.save(parentEntity);
    parentEntity.getComponents().stream().forEach(element -> elementRepo.save(element));
    return null;
  }

  private ElementEntity buildElementEntity(SetupRequestDTO setupRequestDTO) {
    ElementEntity parent = ElementEntity.builder()
        .nombre(setupRequestDTO.getNameElement())
        .build();
    List<ElementEntity> child = getComponentsWishesInElement(setupRequestDTO, parent);
    parent.setComponents(child);
    return parent;
  }

  private List<ElementEntity> getComponentsWishesInElement(SetupRequestDTO setupRequestDTO, ElementEntity parent) {
    return setupRequestDTO.getNameComponentsWished()
        .stream()
        .filter( Objects::nonNull)
        .map(
            wishedElement ->  ElementEntity.builder()
                .nombre(wishedElement)
                .parent(parent)
                .build())
        .collect( Collectors.toList());
  }
}
