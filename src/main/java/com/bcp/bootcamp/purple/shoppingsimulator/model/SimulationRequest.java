package com.bcp.bootcamp.purple.shoppingsimulator.model;

import lombok.Data;

@Data
public class SimulationRequest {

  private String dni;
  private String card;
  private String currency;
  private String amount;
  private String fees;
  private String tea;
  private String payDay;
}
