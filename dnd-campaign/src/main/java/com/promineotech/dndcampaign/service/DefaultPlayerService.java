package com.promineotech.dndcampaign.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.dndcampaign.dao.PlayerDao;
import com.promineotech.dndcampaign.entity.Player;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPlayerService implements PlayerService {

  @Autowired
  private PlayerDao playerDao;
  @Override
  public Optional<Player> fetchPlayerId(Long playerID) {
   log.debug("Service layer enacting fetchPlayer method");
    return playerDao.fetchPlayerId(playerID);
  }
  @Override
  public Optional<Player> createNewPlayer(String firstName, String lastName, String phoneNumber) {
    
    return playerDao.createNewPlayer(firstName, lastName, phoneNumber);
  }
  @Override
  public Optional<Player> updateExistingPlayer(String firstName, String lastName,
      String phoneNumber, Long playerID) {
    
    return playerDao.updateExistingPlayer(firstName, lastName, phoneNumber, playerID);
  }
  @Override
  public Optional<Player> deletePlayer(Long playerID){
    return playerDao.deletePlayer(playerID);
  }

}
