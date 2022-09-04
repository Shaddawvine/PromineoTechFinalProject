package com.promineotech.dndcampaign.service;

import java.util.Optional;
import com.promineotech.dndcampaign.entity.PlayerCharacter;

public interface PlayerCharacterService {
  Optional<PlayerCharacter> fetchPlayerCharacter(Long playerID, Long pcID);
  Optional<PlayerCharacter> createNewPlayerCharacter(Long playerID, String firstName, String lastName, Long lvl, String className, String race);
  Optional<PlayerCharacter> updateExistingPlayerCharacter(Long pcID,Long playerID, String firstName, String lastName, Long lvl, String className, String race);
  Optional<PlayerCharacter> deletePlayerCharacter(Long pcID, Long playerID);
}
