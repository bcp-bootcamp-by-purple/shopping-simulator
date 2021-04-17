package com.bcp.bootcamp.purple.shoppingsimulator.service.formula;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditCalculationTest {

  private CreditCalculation creditCalculation;

  @BeforeEach
  void setUp() {
    creditCalculation = new CreditCalculation();
  }

  @Test
  void calculateTem() {
    var tea = 81.65;
    var expected = 5.10;
    var actual = creditCalculation.calculateTem(tea);
    assertEquals(expected, actual);
  }

  @Test
  void calculateMonthlyFee() {
    var loanAmount = 2500.0;
    var tem = 5.10;
    var fees = 12;
    var expected = 283.66;
    var actual = creditCalculation.calculateMonthlyFee(loanAmount, tem, fees);
    assertEquals(expected, actual);
  }

  @Test
  void calculateMonthlyInterestFee() {
    var tiea = 81.65;
    var numberDaysFee = 30;
    var capitalBalance = 2500.00;
    var expected = 127.50;
    var actual = creditCalculation.calculateMonthlyInterestFee(tiea, numberDaysFee, capitalBalance);
    assertEquals(expected, actual);
  }

  @Test
  void calculateCreditLifeInsurance() {
  }

  @Test
  void calculateFinalFee() {
  }

  @Test
  void calculateAnnualEffectiveCostRate() {
  }

  @Test
  void calculateCompensatoryInterestDueFee() {
  }

  @Test
  void calculateFirstDateFee() {
    var expected = "1";
    var actual = creditCalculation.calculateFirstDateFee("1");
    assertEquals(expected, actual.substring(0, 1));
  }
}
