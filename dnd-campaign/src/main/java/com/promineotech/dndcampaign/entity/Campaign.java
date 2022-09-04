package com.promineotech.dndcampaign.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Campaign {

  private Long campaignID;
  private Long gmID;
  private Long playerID;
}
