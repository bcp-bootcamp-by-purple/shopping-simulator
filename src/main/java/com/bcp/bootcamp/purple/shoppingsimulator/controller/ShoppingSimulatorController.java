package com.bcp.bootcamp.purple.shoppingsimulator.controller;

import com.bcp.bootcamp.purple.shoppingsimulator.model.Card;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Fees;
import com.bcp.bootcamp.purple.shoppingsimulator.model.PayDay;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationRequest;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationResponse;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Tea;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v0/shopping-simulator")
public class ShoppingSimulatorController {

  @GetMapping("/cards-types")
  public List<Card> getCardTypes() {
    return null;
  }

  @GetMapping("/fees")
  public Fees getFees() {
    return null;
  }

  @GetMapping("/pay-days")
  public List<PayDay> getPayDays() {
    return null;
  }

  @GetMapping("/teas")
  public List<Tea> getTeas() {
    return null;
  }

  @PostMapping("/simulation")
  public SimulationResponse simulation(@RequestBody SimulationRequest request) {
    return null;
  }
}
