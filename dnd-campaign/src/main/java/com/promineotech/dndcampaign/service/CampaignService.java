package com.promineotech.dndcampaign.service;

import java.util.Optional;
import com.promineotech.dndcampaign.entity.Campaign;

public interface CampaignService {
  Optional<Campaign> fetchCampaign(Long campaignID);
}
