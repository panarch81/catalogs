package com.globant.semisenior.business;

import com.globant.semisenior.entitities.CategoryEntity;
import com.globant.semisenior.entitities.ElementEntity;
import com.globant.semisenior.repositories.CategoryRepo;
import com.globant.semisenior.repositories.ElementRepo;
import com.globant.semisenior.rest.controller.DTO.SetupRequestDTO;
import com.globant.semisenior.rest.controller.DTO.SetupResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class SetupServiceImpl implements SetupService {

  private final ElementRepo elementRepo;
  private final CategoryRepo categoryRepo;

  public SetupServiceImpl(ElementRepo elementRepo,
      CategoryRepo categoryRepo) {
    this.elementRepo = elementRepo;
    this.categoryRepo = categoryRepo;
  }

  @Override
  public SetupResponseDTO create(SetupRequestDTO setupRequestDTO, String category) {
    ElementEntity parentEntity = buildElementEntity(setupRequestDTO);

    Optional<CategoryEntity> optionalCategoryEntity = categoryRepo.findByName(category);

    if(optionalCategoryEntity.isPresent()){
      CategoryEntity categoryEntity = optionalCategoryEntity.get();
      List<ElementEntity> elementsOfCategory = categoryEntity.getElements();

      if(isElementsPresentAndElementNew( parentEntity, elementsOfCategory )){
        elementsOfCategory.add(parentEntity);
        categoryEntity.setElements(elementsOfCategory);
        categoryRepo.save(categoryEntity);

        parentEntity.setCategory(categoryEntity);
        elementRepo.save(parentEntity);
        parentEntity.getComponents().stream().forEach(element -> elementRepo.save(element));
      }
      else{
        if(CollectionUtils.isEmpty(elementsOfCategory)){
          List<ElementEntity> newElementsOfCategory = new ArrayList<>();
          newElementsOfCategory.add(parentEntity);
        }

        Optional<ElementEntity> optionalParent = elementsOfCategory.stream()
            .filter( parent -> parent.getName().equals( parentEntity.getName() ) )
            .findFirst();

        if(optionalParent.isPresent()){
          ElementEntity parent = optionalParent.get();
          List<ElementEntity> currentComponents = parent.getComponents();
          currentComponents.addAll(parentEntity.getComponents());
          parent.setComponents(currentComponents);

          elementsOfCategory.stream()
              .filter(elementEntity -> elementEntity.getName().equals(parentEntity.getName()))
              .forEach(elementEntity -> elementEntity = parent);

          categoryEntity.setElements(elementsOfCategory);
          categoryRepo.save(categoryEntity);

          elementRepo.save(parent);
          parent.getComponents().stream().forEach(element -> elementRepo.save(element));
        }
      }
    }
    else{

      CategoryEntity categoryEntity=   CategoryEntity.builder().name(category).build();

      List<ElementEntity> newElementsOfCategory = new ArrayList<>();
      newElementsOfCategory.add(parentEntity);
      categoryEntity.setElements(newElementsOfCategory);
      categoryRepo.save(categoryEntity);

      parentEntity.setCategory(categoryEntity);
      elementRepo.save(parentEntity);
      parentEntity.getComponents().stream().forEach(element -> elementRepo.save(element));
    }
    return null;
  }

  private boolean isElementsPresentAndElementNew(ElementEntity parentEntity,
      List<ElementEntity> elementsOfCategory) {
    return !CollectionUtils.isEmpty(elementsOfCategory)
        && elementsOfCategory.stream()
        .noneMatch(e -> e.getName().equals( parentEntity.getName()));
  }

  private ElementEntity buildElementEntity(SetupRequestDTO setupRequestDTO) {
    ElementEntity parent = ElementEntity.builder()
        .name(setupRequestDTO.getNameElement())
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
                .name(wishedElement)
                .parent(parent)
                .build())
        .collect( Collectors.toList());
  }
}
