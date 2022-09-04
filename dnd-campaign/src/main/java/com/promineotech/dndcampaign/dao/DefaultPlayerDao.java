package com.promineotech.dndcampaign.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import com.promineotech.dndcampaign.entity.Player;

//@Component
@Service
public class DefaultPlayerDao implements PlayerDao {
 
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Override
  public Optional<Player> fetchPlayerId(Long playerID) {
    String sql = ""
        + "Select * "
        + "From player "
        + "Where player_id = :player_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("player_id", playerID);
    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new PlayerResultSetExtractor()));
  }

  class PlayerResultSetExtractor implements ResultSetExtractor<Player>{

    @Override
    public Player extractData(ResultSet rs) throws SQLException, DataAccessException {
     rs.next();
      return Player.builder()
          .playerID(rs.getLong("player_id"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .phoneNumber(rs.getString("phone_number"))
          .build();
    }  
   }
  
  public  Optional<Player> createNewPlayer(String firstName, String lastName, String phoneNumber) {
   SqlParams params = generateInsertSql(firstName, lastName, phoneNumber);
   KeyHolder keyHolder = new GeneratedKeyHolder();
   jdbcTemplate.update(params.sql, params.source, keyHolder);

   Long playerID = keyHolder.getKey().longValue();
   return Optional.of(Player.builder()
       .playerID(playerID)
       .firstName(firstName)
       .lastName(lastName)
       .phoneNumber(phoneNumber)
       .build());
        
  }
  public Optional<Player> updateExistingPlayer(String firstName, String lastName, String phoneNumber, Long playerID){
    SqlParams params = generateUpdateSql(firstName, lastName, phoneNumber, playerID);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(Player.builder()
        .playerID(playerID)
        .firstName(firstName)
        .lastName(lastName)
        .phoneNumber(phoneNumber)
        .build());
  }
  
  private SqlParams generateInsertSql(String firstName, String lastName, String phoneNumber) {
    String sql = "Insert into player(first_name, last_name, phone_number) "
        + "Values (:first_name,:last_name,:phone_number)";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("first_name", firstName);
    params.source.addValue("last_name", lastName);
    params.source.addValue("phone_number", phoneNumber);
    return params;
  }
    
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
   
  private SqlParams generateUpdateSql(String firstName, String lastName, String phoneNumber, Long playerID) {
    String sql = "Update player " 
               + "Set first_name = :first_name, last_name = :last_name, phone_number = :phone_number "
               + "Where player_id = :player_id";
    
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("first_name", firstName);
    params.source.addValue("last_name", lastName);
    params.source.addValue("phone_number", phoneNumber);
    Map<String, Object> params2 = new HashMap<>();
    params2.put("player_id", playerID);
    params.source.addValues(params2);
    return params;
  }
  
  public Optional<Player> deletePlayer(Long playerID){
    SqlParams params = generateDeleteSql(playerID);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    return Optional.of(Player.builder()
        .playerID(playerID)
        .build());
  }
  
  private SqlParams generateDeleteSql(Long playerID) {
    String sql = "Delete From player Where player_id = :player_id";
    SqlParams params = new SqlParams();
    params.sql = sql; 
    Map<String, Object> params2 = new HashMap<>();
    params2.put("player_id", playerID);
    params.source.addValues(params2);
    return params;
  }
}
