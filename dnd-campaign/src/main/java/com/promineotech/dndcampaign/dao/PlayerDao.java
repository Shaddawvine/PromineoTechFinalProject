package com.promineotech.dndcampaign.dao;

import java.util.Optional;
import com.promineotech.dndcampaign.entity.Player;

public interface PlayerDao {
  Optional<Player> fetchPlayerId(Long playerID);
  Optional<Player> createNewPlayer(String firstName, String lastName, String phoneNumber);
  Optional<Player> updateExistingPlayer(String firstName, String lastName, String phoneNumber, Long playerID);
  Optional<Player> deletePlayer(Long playerID);
}
