package com.promineotech.dndcampaign.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.dndcampaign.entity.Player;
import com.promineotech.dndcampaign.service.PlayerService;

@RestController
public class DefaultPlayerController implements PlayerController {

  @Autowired
  private PlayerService playerService;
  @Override
  public Optional<Player> fetchPlayerId(Long playerID) {
    return playerService.fetchPlayerId(playerID);
  }
  @Override
  public Optional<Player> createNewPlayer(String firstName, String lastName, String phoneNumber) {
    return playerService.createNewPlayer(firstName, lastName, phoneNumber);
  }
  @Override
  public Optional<Player> updateExistingPlayer(String firstName, String lastName,
      String phoneNumber, Long playerID) {
    return playerService.updateExistingPlayer(firstName, lastName, phoneNumber, playerID);
  }
  @Override
  public Optional<Player> deletePlayer(Long playerID) {
    return playerService.deletePlayer(playerID);
  }

}
