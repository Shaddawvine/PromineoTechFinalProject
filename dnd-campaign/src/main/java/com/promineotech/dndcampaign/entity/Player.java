package com.promineotech.dndcampaign.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
  private Long playerID;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  
}
