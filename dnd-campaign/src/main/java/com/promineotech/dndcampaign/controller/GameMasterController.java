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
import com.promineotech.dndcampaign.entity.GameMaster;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/game_master")
@OpenAPIDefinition(info = @Info(title = "game_master"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface GameMasterController {
  
  @Operation(
      summary = "Returns a list of Game Masters",
      description = "Returns a list of Game Masters by their id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of players are returned.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = GameMaster.class))),
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
  Optional<GameMaster> fetchGameMaster(
      @RequestParam(required = false)Long gmID);
  
  @Operation(
      summary = "Create a new Game Master",
      description = "Creates a new game master in the database",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A new player was created.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = GameMaster.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "Player cannot be created with the input criteria.",
              content = @Content(mediaType= "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.",
              content = @Content(mediaType= "application/json"))
      },
      parameters = {
          @Parameter(
              name = "gm_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "gm by id")
      }
     )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public  Optional<GameMaster> createNewGameMaster(
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName,
      @RequestParam(required = false) String phoneNumber);

  @Operation(
      summary = "Updating a Game Master in the list",
      description = "Updates a gm's information by their id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of players are returned.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = GameMaster.class))),
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
              name = "gm_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "gm by id")
      }
     )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<GameMaster> updateExistingGameMaster(
      @RequestParam(required = false)String firstName, 
      @RequestParam(required = false)String lastName, 
      @RequestParam(required = false)String phoneNumber, 
      @RequestParam(required = false)Long gmID);

  @Operation(
      summary = "Deletes a Game Master",
      description = "Deletes a gm by their id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Player has been deleted.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = GameMaster.class))),
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
              name = "gm_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "gm by id")
      }
     )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  public Optional<GameMaster> deleteGameMaster(
      @RequestParam(required = false)Long gmID);
  
}
