package com.promineotech.dndcampaign.controller;

import java.util.Optional;
import com.promineotech.dndcampaign.entity.Campaign;

public interface CampaignController {
  Optional<Campaign> fetchCampaign(Long campaignID);
}
