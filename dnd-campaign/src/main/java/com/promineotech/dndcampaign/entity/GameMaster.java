package com.promineotech.dndcampaign.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameMaster {
  
  private Long gmID;
  private String firstName;
  private String lastName;
  private String phoneNumber;
}
