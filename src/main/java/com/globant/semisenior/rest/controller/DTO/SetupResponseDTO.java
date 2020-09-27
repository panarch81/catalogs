package com.globant.semisenior.rest.controller.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Setup Response DTO")
public class SetupResponseDTO {

  @ApiModelProperty(value = "Status response")
  private String status;
  @ApiModelProperty(value = "Message response")
  private String message;

  private String nameElement;

  private List<String> nameComponentsWished;

  private List<String> nameComponentsGot;

  private List<String> nameComponentsPending;
}
