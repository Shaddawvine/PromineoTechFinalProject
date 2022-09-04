package com.promineotech.dndcampaign.service;

import java.util.Optional;
import com.promineotech.dndcampaign.entity.Player;

public interface PlayerService {

  public Optional<Player> fetchPlayerId(Long playerID);
  public  Optional<Player> createNewPlayer(String firstName, String lastName, String phoneNumber);
  public Optional<Player> updateExistingPlayer(String firstName, String lastName, String phoneNumber, Long playerID);
  public Optional<Player> deletePlayer(Long playerID);
}
