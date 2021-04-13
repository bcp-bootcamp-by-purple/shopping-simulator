package com.bcp.bootcamp.purple.shoppingsimulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimulationResponse {

  @JsonProperty("cuota")
  private Double feesAmount;

  @JsonProperty("moneda")
  private String currency;

  @JsonProperty("primeraCuota")
  private String firstPaymentDate;

  @JsonProperty("estado")
  private String status;
}
