package com.bcp.bootcamp.purple.shoppingsimulator.controller;

import com.bcp.bootcamp.purple.shoppingsimulator.model.Card;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Fees;
import com.bcp.bootcamp.purple.shoppingsimulator.model.PayDay;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationRequest;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationResponse;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Tea;
import com.bcp.bootcamp.purple.shoppingsimulator.service.ShoppingSimulatorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v0/shopping-simulator")
public class ShoppingSimulatorController {

  private final ShoppingSimulatorService simulatorService;

  @GetMapping("/cards-types")
  public List<Card> getCardTypes() {
    return simulatorService.getCardTypes();
  }

  @GetMapping("/fees")
  public Fees getFees() {
    return simulatorService.getFees();
  }

  @GetMapping("/pay-days")
  public List<PayDay> getPayDays() {
    return simulatorService.getPayDays();
  }

  @GetMapping("/teas")
  public List<Tea> getTeas() {
    return simulatorService.getTeas();
  }

  @PostMapping("/calculation")
  public SimulationResponse calculateShopping(@RequestBody SimulationRequest request) {
    return simulatorService.calculateShopping(request);
  }
}
