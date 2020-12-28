package com.globant.semisenior.rest.controller.DTO;

import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Continent DTO")
public class ContinentDTO {
  private int id;

  private String name;

  private List<CountryDTO> countries;

}
