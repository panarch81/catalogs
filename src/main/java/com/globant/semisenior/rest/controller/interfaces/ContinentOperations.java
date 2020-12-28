package com.globant.semisenior.rest.controller.interfaces;

import com.globant.semisenior.rest.controller.DTO.ContinentDTO;
import com.globant.semisenior.rest.controller.DTO.SetupResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/continent")
public interface ContinentOperations {
  @ApiOperation(
      value = "Controller that create a continent",
      notes = "Given a continent with countries and these with cities",
      response = SetupResponseDTO.class
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 500, message = "Internal server error")})
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ContinentDTO> create(
      @RequestBody final ContinentDTO continent);

  @ApiOperation(
      value = "Controller that get the continents",
      notes = "Given a continentId",
      response = SetupResponseDTO.class
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 500, message = "Internal server error")})
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ContinentDTO> getContinent(@PathVariable(value = "id")
      Long continentId);

}
