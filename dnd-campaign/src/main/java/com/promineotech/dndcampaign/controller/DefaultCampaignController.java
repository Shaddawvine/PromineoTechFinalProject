package com.promineotech.dndcampaign.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.dndcampaign.entity.Campaign;
import com.promineotech.dndcampaign.service.CampaignService;

@RestController
public class DefaultCampaignController implements CampaignController {

  private CampaignService campaignService;
  @Override
  public Optional<Campaign> fetchCampaign(Long campaignID) {
    return campaignService.fetchCampaign(campaignID);
  }

}
