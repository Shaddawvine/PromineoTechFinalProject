package com.promineotech.dndcampaign.dao;

import java.util.Optional;
import com.promineotech.dndcampaign.entity.Campaign;

public interface CampaignDao {
  Optional<Campaign> fetchCampaign(Long campaignID);
}
