package com.promineotech.dndcampaign.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.dndcampaign.entity.GameMaster;
import com.promineotech.dndcampaign.service.GameMasterService;

@RestController
public class DefaultGameMasterController implements GameMasterController {

  @Autowired
  private GameMasterService gameMasterService;
  
  @Override
  public Optional<GameMaster> fetchGameMaster(Long gmID) {
    return gameMasterService.fetchGameMaster(gmID);
  }
  @Override
  public Optional<GameMaster> createNewGameMaster(String firstName, String lastName,
      String phoneNumber) {
    return gameMasterService.createNewGameMaster(firstName, lastName, phoneNumber);
  }
  @Override
  public Optional<GameMaster> updateExistingGameMaster(String firstName, String lastName,
      String phoneNumber, Long gmID) {
    return gameMasterService.updateExistingGameMaster(firstName, lastName, phoneNumber, gmID);
  }
  @Override
  public Optional<GameMaster> deleteGameMaster(Long gmID) {
    return gameMasterService.deleteGameMaster(gmID);
  }

}
