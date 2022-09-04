package com.promineotech.dndcampaign.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.promineotech.dndcampaign"})
public class DnDApp {

  public static void main(String[] args) {
    SpringApplication.run(DnDApp.class, args);
  }
}
