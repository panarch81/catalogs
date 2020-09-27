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
@ApiModel(description = "Setup Request DTO")
public class SetupRequestDTO {

    private int id;

    private String nameElement;

    private List<String> nameComponentsWished;

}
