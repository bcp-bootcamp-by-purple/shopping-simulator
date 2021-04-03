package com.bcp.bootcamp.purple.shoppingsimulator.model;

import lombok.Data;

@Data
public class SimulationResponse {

  private String feesAmount;
  private String currency;
  private String firstPaymentDate;
  private String status;
}
