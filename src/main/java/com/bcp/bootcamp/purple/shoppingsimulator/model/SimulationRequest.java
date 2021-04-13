package com.bcp.bootcamp.purple.shoppingsimulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SimulationRequest {

  @JsonProperty("dni")
  private String dni;

  @JsonProperty("tarjeta")
  private String card;

  @JsonProperty("moneda")
  private String currency;

  @JsonProperty("monto")
  private Double amount;

  @JsonProperty("cuota")
  private Integer fees;

  @JsonProperty("tea")
  private Double tea;

  @JsonProperty("diaPago")
  private String payDay;
}
