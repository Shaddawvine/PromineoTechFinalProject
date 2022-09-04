package com.promineotech.dndcampaign.service;

import java.util.Optional;
import com.promineotech.dndcampaign.entity.GameMaster;

public interface GameMasterService {
  Optional<GameMaster> fetchGameMaster(Long gmID);
  Optional<GameMaster> createNewGameMaster(String firstName, String lastName, String phoneNumber);
  Optional<GameMaster> updateExistingGameMaster(String firstName, String lastName, String phoneNumber, Long gmID);
  Optional<GameMaster> deleteGameMaster(Long gmID);
}
