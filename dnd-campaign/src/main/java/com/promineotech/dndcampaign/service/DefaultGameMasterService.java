package com.promineotech.dndcampaign.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.dndcampaign.dao.GameMasterDao;
import com.promineotech.dndcampaign.entity.GameMaster;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultGameMasterService implements GameMasterService {

  @Autowired
  private GameMasterDao gameMasterDao;
  
  @Override
  public Optional<GameMaster> fetchGameMaster(Long gmID) {
   log.debug("Service layer enacting fetchGameMaster method");
    return gameMasterDao.fetchGameMaster(gmID);
  }
  @Override
  public Optional<GameMaster> createNewGameMaster(String firstName, String lastName,
      String phoneNumber) {
    return gameMasterDao.createNewGameMaster(firstName, lastName, phoneNumber);
  }
  @Override
  public Optional<GameMaster> updateExistingGameMaster(String firstName, String lastName,
      String phoneNumber, Long gmID) {
    return gameMasterDao.updateExistingGameMaster(firstName, lastName, phoneNumber, gmID);
  }
  @Override
  public Optional<GameMaster> deleteGameMaster(Long gmID) {
    return gameMasterDao.deleteGameMaster(gmID);
  }

}
