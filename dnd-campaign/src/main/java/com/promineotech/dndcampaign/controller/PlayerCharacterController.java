package com.promineotech.dndcampaign.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.dndcampaign.entity.PlayerCharacter;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/player_pc")
@OpenAPIDefinition(info = @Info(title = "player_pc"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})


public interface PlayerCharacterController {
 
  @Operation(
      summary = "Returns a list of players' characters",
      description = "Returns a list of player character by their id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of players are returned.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = PlayerCharacter.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No players were found with the input criteria.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.",
              content = @Content(mediaType= "application/json"))
      },
      parameters = {
          @Parameter(
              name = "pc_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "player character by id")
      }
     )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<PlayerCharacter> fetchPlayerCharacter(
      @RequestParam(required = false)Long playerID,
      @RequestParam(required = false)Long pcID);
  
  @Operation(
      summary = "Create a new playable character",
      description = "Create a new playable character by player id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of players are returned.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = PlayerCharacter.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No players were found with the input criteria.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.",
              content = @Content(mediaType= "application/json"))
      },
      parameters = {
          @Parameter(
              name = "pc_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "player character by id")
      }
     )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<PlayerCharacter> createNewPlayerCharacter(
      @RequestParam(required = false)Long pcID,
      @RequestParam(required = false)Long playerID,
      @RequestParam(required = false)String firstName,
      @RequestParam(required = false)String lastName,
      @RequestParam(required = false)Long lvl,
      @RequestParam(required = false)String className,
      @RequestParam(required = false)String race);
  
  @Operation(
      summary = "Update a playable character by player id",
      description = "Updates a playable character by player id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of players are returned.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = PlayerCharacter.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No players were found with the input criteria.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.",
              content = @Content(mediaType= "application/json"))
      },
      parameters = {
          @Parameter(
              name = "pc_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "player character by id")
      }
     )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<PlayerCharacter> updateExistingPlayerCharacter(
      @RequestParam(required = false)Long pcID,
      @RequestParam(required = false)Long playerID,
      @RequestParam(required = false)String firstName,
      @RequestParam(required = false)String lastName,
      @RequestParam(required = false)Long lvl,
      @RequestParam(required = false)String className,
      @RequestParam(required = false)String race);
  
  @Operation(
      summary = "Deletes a player character by player id",
      description = "Deletes a playable character by player id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of players are returned.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = PlayerCharacter.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No players were found with the input criteria.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.",
              content = @Content(mediaType= "application/json"))
      },
      parameters = {
          @Parameter(
              name = "pc_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "player character by id")
      }
     )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<PlayerCharacter> deletePlayerCharacter(
      @RequestParam(required = false)Long pcID,
      @RequestParam(required = false)Long playerID);
}
