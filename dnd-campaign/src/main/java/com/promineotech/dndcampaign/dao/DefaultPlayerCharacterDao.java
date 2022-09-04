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
import com.promineotech.dndcampaign.entity.PlayerCharacter;

//@Component
@Service
public class DefaultPlayerCharacterDao implements PlayerCharacterDao{
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  public Optional<PlayerCharacter> fetchPlayerCharacter(Long playerID, Long pcID) {
  String sql = ""
      + "Select * "
      + "From player_pc "
      + "Where player_id = :player_id "
      + "And pc_id = :pc_id";
  
    Map<String, Object> params = new HashMap<>();
    params.put("player_id", playerID);
    params.put("pc_id", pcID);
  return Optional.ofNullable(
      jdbcTemplate.query(sql, params, new PlayerCharacterResultSetExtractor()));
      }
  class PlayerCharacterResultSetExtractor implements ResultSetExtractor<PlayerCharacter> {
   
      @Override
      public PlayerCharacter extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
       return PlayerCharacter.builder()
           .pcID(rs.getLong("pc_id"))
           .playerID(rs.getLong("player_id"))
           .firstName(rs.getString("first_name"))
           .lastName(rs.getString("last_name"))
           .lvl(rs.getLong("lvl"))
           .className(rs.getString("class"))
           .race(rs.getString("race"))
           .build();
           
     }    
  }
  public  Optional<PlayerCharacter> createNewPlayerCharacter(Long playerID, String firstName, String lastName, Long lvl, String className, String race) {
    SqlParams params = generateInsertSql(playerID,firstName, lastName, lvl, className, race);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);

    Long pcID = keyHolder.getKey().longValue();
    return Optional.of(PlayerCharacter.builder()
        .pcID(pcID)
        .playerID(playerID)
        .firstName(firstName)
        .lastName(lastName)
        .lvl(lvl)
        .className(className)
        .race(race)
        .build());
         
   }
   
  public Optional<PlayerCharacter> updateExistingPlayerCharacter(Long pcID,Long playerID, String firstName, String lastName, Long lvl, String className, String race){
     SqlParams params = generateUpdateSql(pcID,playerID,firstName, lastName,lvl, className,race);
     KeyHolder keyHolder = new GeneratedKeyHolder();
     jdbcTemplate.update(params.sql, params.source, keyHolder);
     return Optional.of(PlayerCharacter.builder()
         .pcID(pcID)
         .playerID(playerID)
         .firstName(firstName)
         .lastName(lastName)
         .lvl(lvl)
         .className(className)
         .race(race)
         .build());
   }
   
   private SqlParams generateInsertSql(Long playerID, String firstName, String lastName, Long lvl, String className, String race) {
     String sql = "Insert into player_pc(player_id,first_name, last_name, lvl, class, race) "
         + "Values (:player_id,:first_name,:last_name,:lvl, :class, :race)";
     
     SqlParams params = new SqlParams();
     params.sql = sql;
     params.source.addValue("player_id", playerID);
     params.source.addValue("first_name", firstName);
     params.source.addValue("last_name", lastName);
     params.source.addValue("lvl", lvl );
     params.source.addValue("class", className);
     params.source.addValue("race", race);
     return params;
   }
     
   
   class SqlParams {
     String sql;
     MapSqlParameterSource source = new MapSqlParameterSource();
   }
    
   private SqlParams generateUpdateSql(Long pcID,Long playerID, String firstName, String lastName, Long lvl, String className, String race) {
     String sql = "Update player_pc " 
                + "Set first_name = :first_name, last_name = :last_name, lvl = :lvl, class = :class, race = :race "
                + "Where pc_id = :pc_id AND player_id = :player_id";
     
     SqlParams params = new SqlParams();
     params.sql = sql;
     params.source.addValue("first_name", firstName);
     params.source.addValue("last_name", lastName);
     params.source.addValue("lvl", lvl );
     params.source.addValue("class", className);
     params.source.addValue("race", race);
     Map<String, Object> params2 = new HashMap<>();
     params2.put("pc_id", pcID);
     params2.put("player_id", playerID);
     params.source.addValues(params2);
     return params;
   }
   
   public Optional<PlayerCharacter> deletePlayerCharacter(Long pcID, Long playerID){
     SqlParams params = generateDeleteSql(pcID,playerID);
     KeyHolder keyHolder = new GeneratedKeyHolder();
     jdbcTemplate.update(params.sql, params.source, keyHolder);
     return Optional.of(PlayerCharacter.builder()
         .pcID(pcID)
         .playerID(playerID)
         .build());
   }
   
   private SqlParams generateDeleteSql(Long pcID,Long playerID) {
     String sql = "Delete From player_pc "
         + "Where pc_id = :pc_id "
         + "AND player_id = :player_id";
     SqlParams params = new SqlParams();
     params.sql = sql; 
     Map<String, Object> params2 = new HashMap<>();
     params2.put("pc_id", pcID);
     params2.put("player_id", playerID);
     params.source.addValues(params2);
     return params;
   }
}
