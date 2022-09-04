package com.promineotech.dndcampaign.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.dndcampaign.controller.CampaignController;
import com.promineotech.dndcampaign.dao.CampaignDao;
import com.promineotech.dndcampaign.entity.Campaign;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCampaignService implements CampaignController {

  private CampaignDao campaignDao;
  @Override
  public Optional<Campaign> fetchCampaign(Long campaignID) {
    log.debug("Service layer enacting fetchCampaign method");
    return campaignDao.fetchCampaign(campaignID);
  }

}
