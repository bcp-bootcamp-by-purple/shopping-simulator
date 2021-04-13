package com.bcp.bootcamp.purple.shoppingsimulator.service.impl;

import com.bcp.bootcamp.purple.shoppingsimulator.model.Card;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Fees;
import com.bcp.bootcamp.purple.shoppingsimulator.model.PayDay;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationRequest;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationResponse;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Tea;
import com.bcp.bootcamp.purple.shoppingsimulator.repository.CardTypeRepository;
import com.bcp.bootcamp.purple.shoppingsimulator.repository.FeesRepository;
import com.bcp.bootcamp.purple.shoppingsimulator.repository.PayDayRepository;
import com.bcp.bootcamp.purple.shoppingsimulator.repository.TeaRepository;
import com.bcp.bootcamp.purple.shoppingsimulator.service.ShoppingSimulatorService;
import com.bcp.bootcamp.purple.shoppingsimulator.util.enums.Status;
import com.bcp.bootcamp.purple.shoppingsimulator.util.formula.CreditCalculation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingSimulatorServiceImpl implements ShoppingSimulatorService {

  private final CardTypeRepository cardTypeRepository;
  private final FeesRepository feesRepository;
  private final PayDayRepository payDayRepository;
  private final TeaRepository teaRepository;

  @Override
  public List<Card> getCardTypes() {
    return cardTypeRepository.findAll();
  }

  @Override
  public Fees getFees() {
    return feesRepository.findAll().get(0);
  }

  @Override
  public List<PayDay> getPayDays() {
    return payDayRepository.findAll();
  }

  @Override
  public List<Tea> getTeas() {
    return teaRepository.findAll();
  }

  @Override
  public SimulationResponse simulation(SimulationRequest request) {
    var tem = CreditCalculation.calculateTem(request.getTea());
    var monthlyFee = CreditCalculation.calculateMonthlyFee(request.getAmount(),
      tem, request.getFees());
    var firstDateFee = CreditCalculation.calculateFirstDateFee();

    return SimulationResponse.builder()
      .feesAmount(monthlyFee)
      .currency(request.getCurrency())
      .firstPaymentDate(firstDateFee)
      .status(Status.SUCCESS.getValue()).build();
  }

}
