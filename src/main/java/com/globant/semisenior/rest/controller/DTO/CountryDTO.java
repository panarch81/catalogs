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
@ApiModel(description = "Country DTO")
public class CountryDTO {
  private int id;

  private String name;

  private List<CityDTO> cities;

}
