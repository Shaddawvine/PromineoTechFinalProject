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
import com.promineotech.dndcampaign.entity.GameMaster;

//@Component
@Service
public class DefaultGameMasterDao implements GameMasterDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  public Optional<GameMaster> fetchGameMaster(Long gmID) {
   String sql = ""
       + "Select * "
       + "From game_master "
       + "Where gm_id = :gm_id";
    
   Map<String, Object> params = new HashMap<>();
   params.put("gm_id", gmID);
       
     return Optional.ofNullable(
         jdbcTemplate.query(sql, params, new GameMasterResultSetExtractor()));
  }

  class GameMasterResultSetExtractor implements ResultSetExtractor<GameMaster> {

    @Override
    public GameMaster extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      return GameMaster.builder()
          .gmID(rs.getLong("gm_id"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .phoneNumber(rs.getString("phone_number"))
          .build();
    }
    
  }
  public  Optional<GameMaster> createNewGameMaster(String firstName, String lastName, String phoneNumber) {
    SqlParams params = generateInsertSql(firstName, lastName, phoneNumber);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);

    Long gmID = keyHolder.getKey().longValue();
    return Optional.of(GameMaster.builder()
        .gmID(gmID)
        .firstName(firstName)
        .lastName(lastName)
        .phoneNumber(phoneNumber)
        .build());
         
   }
   public Optional<GameMaster> updateExistingGameMaster(String firstName, String lastName, String phoneNumber, Long gmID){
     SqlParams params = generateUpdateSql(firstName, lastName, phoneNumber, gmID);
     KeyHolder keyHolder = new GeneratedKeyHolder();
     jdbcTemplate.update(params.sql, params.source, keyHolder);
     return Optional.of(GameMaster.builder()
         .gmID(gmID)
         .firstName(firstName)
         .lastName(lastName)
         .phoneNumber(phoneNumber)
         .build());
   }
   
   private SqlParams generateInsertSql(String firstName, String lastName, String phoneNumber) {
     String sql = "Insert into game_master(first_name, last_name, phone_number) "
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
    
   private SqlParams generateUpdateSql(String firstName, String lastName, String phoneNumber, Long gmID) {
     String sql = "Update game_master " 
                + "Set first_name = :first_name, last_name = :last_name, phone_number = :phone_number "
                + "Where gm_id = :gm_id";
     
     SqlParams params = new SqlParams();
     params.sql = sql;
     params.source.addValue("first_name", firstName);
     params.source.addValue("last_name", lastName);
     params.source.addValue("phone_number", phoneNumber);
     Map<String, Object> params2 = new HashMap<>();
     params2.put("gm_id", gmID);
     params.source.addValues(params2);
     return params;
   }
   
   public Optional<GameMaster> deleteGameMaster(Long gmID){
     SqlParams params = generateDeleteSql(gmID);
     KeyHolder keyHolder = new GeneratedKeyHolder();
     jdbcTemplate.update(params.sql, params.source, keyHolder);
     return Optional.of(GameMaster.builder()
         .gmID(gmID)
         .build());
   }
   
   private SqlParams generateDeleteSql(Long gmID) {
     String sql = "Delete From game_master Where gm_id = :gm_id";
     SqlParams params = new SqlParams();
     params.sql = sql; 
     Map<String, Object> params2 = new HashMap<>();
     params2.put("gm_id", gmID);
     params.source.addValues(params2);
     return params;
   }
 
}
