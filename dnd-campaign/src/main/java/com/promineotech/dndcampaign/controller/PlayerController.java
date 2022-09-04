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
import com.promineotech.dndcampaign.entity.Player;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/player")
@OpenAPIDefinition(info = @Info(title = "Player"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface PlayerController {
  
  @Operation(
      summary = "Returns a player",
      description = "Returns a player by their id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of players are returned.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = Player.class))),
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
              name = "player_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "player by id")
      }
     )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Player> fetchPlayerId(
    @RequestParam(required = false) Long player);
  
  
  @Operation(
      summary = "Create a new player",
      description = "Creates a new player in the database",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A new player was created.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = Player.class))),
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
              name = "player_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "player by id")
      }
     )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public  Optional<Player> createNewPlayer(
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName,
      @RequestParam(required = false) String phoneNumber);

  @Operation(
      summary = "Updating a player in the list",
      description = "Updates a players information by their id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of players are returned.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = Player.class))),
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
              name = "player_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "player by id")
      }
     )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Player> updateExistingPlayer(
      @RequestParam(required = false)String firstName, 
      @RequestParam(required = false)String lastName, 
      @RequestParam(required = false)String phoneNumber, 
      @RequestParam(required = false)Long playerID);

  @Operation(
      summary = "Deletes a player",
      description = "Deletes a player by their id",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "Player has been deleted.",
              content = @Content(mediaType= "application/json", 
              schema = @Schema(implementation = Player.class))),
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
              name = "player_id", 
              allowEmptyValue = false, 
              required = false, 
              description = "player by id")
      }
     )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  public Optional<Player> deletePlayer(
      @RequestParam(required = false)Long playerID);
  
  
  
}
