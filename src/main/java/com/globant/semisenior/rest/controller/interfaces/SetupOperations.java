package com.globant.semisenior.rest.controller.interfaces;

import com.globant.semisenior.rest.controller.DTO.SetupRequestDTO;
import com.globant.semisenior.rest.controller.DTO.SetupResponseDTO;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/setup")
public interface SetupOperations {

  @ApiOperation(
      value = "Controller that handle the setup to initialize",
      notes = "Given a productName and Id",
      response = SetupResponseDTO.class
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 500, message = "Internal server error")})
  @PostMapping(path = "/create/{category}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<SetupResponseDTO> create(
      @PathVariable(value = "category") final String category,
      @RequestBody final SetupRequestDTO setupRequestDTO
  );

}
