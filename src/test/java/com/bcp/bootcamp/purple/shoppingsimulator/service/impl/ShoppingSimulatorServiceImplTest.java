package com.bcp.bootcamp.purple.shoppingsimulator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationRequest;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationResponse;
import com.bcp.bootcamp.purple.shoppingsimulator.service.ShoppingSimulatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingSimulatorServiceImplTest {

  @Autowired
  private ShoppingSimulatorService simulatorService;

  @Test
  void getCardTypes() {
    var expected = 3;
    var actual = simulatorService.getCardTypes();
    assertEquals(expected, actual.size());
  }

  @Test
  void getFees() {
    var expected = 1;
    var actual = simulatorService.getFees();
    assertEquals(expected, actual.getMin());
  }

  @Test
  void getPayDays() {
    var expected = 2;
    var actual = simulatorService.getPayDays();
    assertEquals(expected, actual.size());
  }

  @Test
  void getTeas() {
    var expected = 3;
    var actual = simulatorService.getTeas();
    assertEquals(expected, actual.size());
  }

  @Test
  void calculateShopping() {
    var request = SimulationRequest.builder()
      .amount(2500.0)
      .card("CLASICA")
      .currency("S/")
      .dni("45654654")
      .fees(12)
      .tea("81.65%")
      .payDay("5").build();
    var expected = SimulationResponse.builder()
      .feesAmount(283.66)
      .currency("S/")
      .firstPaymentDate("5/5/2021")
      .status("exitoso").build();
    var actual = simulatorService.calculateShopping(request);
    System.out.println(actual);
    assertEquals(expected, actual);
  }
}
