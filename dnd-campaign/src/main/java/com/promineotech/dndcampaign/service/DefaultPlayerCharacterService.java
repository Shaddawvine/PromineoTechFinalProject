/**
 * 
 */
package com.promineotech.dndcampaign.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.dndcampaign.dao.PlayerCharacterDao;
import com.promineotech.dndcampaign.entity.PlayerCharacter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPlayerCharacterService implements PlayerCharacterService {

  @Autowired
  private PlayerCharacterDao playerCharacterDao;
  @Override
  public Optional<PlayerCharacter> fetchPlayerCharacter(Long playerID,Long pcID) {
  log.debug("Service layer enacting fetchPlayerCharacter method");
    return playerCharacterDao.fetchPlayerCharacter(pcID, pcID);
  }
  @Override
  public Optional<PlayerCharacter> createNewPlayerCharacter(Long playerID, String firstName,
      String lastName, Long lvl, String className, String race) {
    return playerCharacterDao.createNewPlayerCharacter(playerID, firstName, lastName, lvl, className, race);
  }
  @Override
  public Optional<PlayerCharacter> updateExistingPlayerCharacter(Long pcID,Long playerID, String firstName,
      String lastName, Long lvl, String className, String race) {
    return playerCharacterDao.updateExistingPlayerCharacter(pcID,playerID, firstName, lastName, lvl, className, race);
  }
  @Override
  public Optional<PlayerCharacter> deletePlayerCharacter(Long pcID, Long playerID) {
    return playerCharacterDao.deletePlayerCharacter(pcID, playerID);
  }

}
