package com.promineotech.dndcampaign.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.dndcampaign.entity.Campaign;

//@Component
@Service
public class DefaultCampaignDao implements CampaignDao{

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Override
  public Optional<Campaign> fetchCampaign(Long campaignID) {
    String sql = ""
        + "Select * "
        + "From campaign "
        + "Where campaign_id = :campaign_id";
        
    Map<String, Object> params = new HashMap<>();
    params.put("campaign_id", campaignID);
    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new CampaignResultSetExtractor()));
  }

  class CampaignResultSetExtractor implements ResultSetExtractor<Campaign>{

    @Override
    public Campaign extractData(ResultSet rs) throws SQLException, DataAccessException {
     rs.next();
      return Campaign.builder()
          .campaignID(rs.getLong("campaign_id"))
          .gmID(rs.getLong("gm_id"))
          .playerID(rs.getLong("player_id"))
          .build();
    }
    
 
    
  }
}