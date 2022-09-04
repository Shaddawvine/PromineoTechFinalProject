package com.promineotech.dndcampaign.dao;

import java.util.Optional;
import com.promineotech.dndcampaign.entity.GameMaster;

public interface GameMasterDao {
  Optional<GameMaster> fetchGameMaster(Long gmID);
  Optional<GameMaster> createNewGameMaster(String firstName, String lastName, String phoneNumber);
  Optional<GameMaster> updateExistingGameMaster(String firstName, String lastName, String phoneNumber, Long gmID);
  Optional<GameMaster> deleteGameMaster(Long gmID);
}
