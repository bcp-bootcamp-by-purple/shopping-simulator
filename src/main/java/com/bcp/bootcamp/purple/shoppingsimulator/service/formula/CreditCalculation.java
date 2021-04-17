package com.bcp.bootcamp.purple.shoppingsimulator.service.formula;

import com.bcp.bootcamp.purple.shoppingsimulator.util.format.Format;
import java.time.LocalDate;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class CreditCalculation {

  /**
   * Cálculo de la tasa efectiva mensual.
   * @param tea Tasa efectiva anual.
   * @return Tasa efectiva mensua.
   */
  public double calculateTem(double tea) {
    return Stream.of(tea)
      .map(t -> Math.pow(1 + (t/100), (30.0/360.0)))
      .map(pow -> (pow - 1) * 100)
      .map(tem -> Format.roundNumber(tem, 2))
      .findFirst().get();
  }

  /**
   * Cálculo de la cuota fija mensua.
   * @param loanAmount Monto del préstamo.
   * @param tem tasa de intereses efectiva mensual.
   * @param fees número de cuotas del crédito.
   * @return cuota mensual a pagar sin gastos.
   */
  public double calculateMonthlyFee(double loanAmount, double tem, int fees) {
    return Format.roundNumber(
      loanAmount * ((tem/100 * Math.pow(1 + tem/100, fees)) / (Math.pow(1 + tem/100, fees) - 1)),
      2);
  }

  /**
   * Cálculo de intereses mensual por cuota.
   * @param tiea tasa de interés efectiva anual.
   * @param numberDaysFee número de días de la cuota.
   * @param capitalBalance saldo capital.
   * @return interés de la cuota.
   */
  public double calculateMonthlyInterestFee(double tiea, int numberDaysFee,
                                                   double capitalBalance) {
    return Format.roundNumber(
      (Math.pow((tiea/100 + 1), (numberDaysFee * 1.0 / 360)) - 1) * capitalBalance,
      2);
  }

  /**
   * Cálculo del Seguro de desgravamen.
   * @param balanceMonth saldo de capital del mes.
   * @param insuranceRate tasa de seguro de desgravamen.
   * @return seguro de desgravamen.
   */
  public double calculateCreditLifeInsurance(double balanceMonth, double insuranceRate) {
    return balanceMonth * insuranceRate;
  }

  /**
   * Cálculo de la cuota final.
   * @param monthlyFee cuota mensual a pagar sin gastos.
   * @param insuranceFee seguro de la cuota.
   * @return cuota final.
   */
  public double calculateFinalFee(double monthlyFee, double insuranceFee) {
    return monthlyFee + insuranceFee;
  }

  /**
   * Cálculo de la Tasa de Costo Efectivo Anual.
   * @param TCEM tasa del costo efectivo mensual.
   * @return tasa del costo efectivo anual.
   */
  public double calculateAnnualEffectiveCostRate(double TCEM) {
    return Math.pow((1 + TCEM), 12) - 1;
  }

  /**
   * Cálculo del interés compensatorio vencido por cuota.
   * @param interestRate tasa de interés del crédito.
   * @param numberDaysLate número de días de atraso.
   * @param monthlyFee Cuota mensual a pagar sin gastos.
   * @return interés compensatorio vencido.
   */
  public double calculateCompensatoryInterestDueFee(double interestRate,
                                                           double numberDaysLate,
                                                           double monthlyFee) {
    return (Math.pow((interestRate + 1), (numberDaysLate / 360)) - 1) * monthlyFee;
  }

  /**
   * Calculo de la fecha de la primera cuota.
   * @return fecha con formato 1/12/2021
   */
  public String calculateFirstDateFee(String payDay) {
    var monthValue = LocalDate.now().plusMonths(1).getMonthValue();
    var year = LocalDate.now().getYear();
    return String.format("%s/%d/%d", payDay, monthValue, year);
  }
}
