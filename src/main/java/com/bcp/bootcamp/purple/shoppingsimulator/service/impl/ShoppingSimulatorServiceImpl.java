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
import com.bcp.bootcamp.purple.shoppingsimulator.service.formula.CreditCalculation;
import com.bcp.bootcamp.purple.shoppingsimulator.util.enums.Status;
import com.bcp.bootcamp.purple.shoppingsimulator.util.format.Format;
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
  private final CreditCalculation creditCalculation;

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
  public SimulationResponse calculateShopping(SimulationRequest request) {
    var tem = creditCalculation
      .calculateTem(Double.parseDouble(request.getTea().substring(0, request.getTea().length() - 1)));
    var monthlyFee = creditCalculation.calculateMonthlyFee(request.getAmount(),
      tem, request.getFees());
    var firstDateFee = creditCalculation.calculateFirstDateFee(request.getPayDay());

    return SimulationResponse.builder()
      .feesAmount(Format.roundNumber(monthlyFee, 2))
      .currency(request.getCurrency())
      .firstPaymentDate(firstDateFee)
      .status(Status.SUCCESS.getValue()).build();
  }

}
