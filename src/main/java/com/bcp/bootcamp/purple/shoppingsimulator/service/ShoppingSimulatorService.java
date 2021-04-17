package com.bcp.bootcamp.purple.shoppingsimulator.service;

import com.bcp.bootcamp.purple.shoppingsimulator.model.Card;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Fees;
import com.bcp.bootcamp.purple.shoppingsimulator.model.PayDay;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationRequest;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationResponse;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Tea;
import java.util.List;

public interface ShoppingSimulatorService {

  List<Card> getCardTypes();
  Fees getFees();
  List<PayDay> getPayDays();
  List<Tea> getTeas();
  SimulationResponse calculateShopping(SimulationRequest request);
}
