package com.promineotech.dndcampaign.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.dndcampaign.entity.PlayerCharacter;
import com.promineotech.dndcampaign.service.PlayerCharacterService;

@RestController
public class DefaultPlayerCharacterController implements PlayerCharacterController {

  @Autowired
  private PlayerCharacterService playerCharacterService;
  @Override
  public Optional<PlayerCharacter> fetchPlayerCharacter(Long playerID, Long pcID) {

    return playerCharacterService.fetchPlayerCharacter(playerID,pcID);
  }
  @Override
  public Optional<PlayerCharacter> createNewPlayerCharacter(Long pcID, Long playerID,
      String firstName, String lastName, Long lvl, String className, String race) {
    return playerCharacterService.createNewPlayerCharacter(playerID, firstName, lastName, lvl, className, race);
  }
  @Override
  public Optional<PlayerCharacter> updateExistingPlayerCharacter(Long pcID, Long playerID,
      String firstName, String lastName, Long lvl, String className, String race) {
    return playerCharacterService.updateExistingPlayerCharacter(pcID,playerID, firstName, lastName, lvl, className, race);
  }
  @Override
  public Optional<PlayerCharacter> deletePlayerCharacter(Long pcID, Long playerID) {
    return playerCharacterService.deletePlayerCharacter(pcID, playerID);
  }

}
