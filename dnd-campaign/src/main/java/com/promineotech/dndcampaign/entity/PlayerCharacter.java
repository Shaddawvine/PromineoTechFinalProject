package com.promineotech.dndcampaign.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerCharacter {
  private Long pcID;
  private Long playerID;
  private String firstName;
  private String lastName;
  private Long lvl;
  private String className;
  private String race;
}
