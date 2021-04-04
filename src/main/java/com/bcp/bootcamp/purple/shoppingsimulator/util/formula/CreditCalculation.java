package com.bcp.bootcamp.purple.shoppingsimulator.util.formula;

public class CreditCalculation {

  /**
   * Cálculo de la tasa efectiva mensual.
   * @param tea Tasa efectiva anual.
   * @return Tasa efectiva mensua.
   */
  public static double calculateTem(double tea) {
    return (Math.pow(1 + (tea/100), (30/360)) - 1) * 100;
  }

  /**
   * Cálculo de la cuota fija mensua.
   * @param loanAmount Monto del préstamo.
   * @param tem tasa de intereses efectiva mensual.
   * @param fees número de cuotas del crédito.
   * @return cuota mensual a pagar sin gastos.
   */
  public static double calculateMonthlyFee(double loanAmount, double tem, int fees) {
    return loanAmount * ((tem * Math.pow(1 + tem, fees))/(Math.pow(1 + tem, fees) - 1));
  }

  /**
   * Cálculo de intereses mensual por cuota.
   * @param tiea tasa de interés efectiva anual.
   * @param numberDaysFee número de días de la cuota.
   * @param capitalBalance saldo capital.
   * @return interés de la cuota.
   */
  public static double calculateMonthlyInterestFee(double tiea, int numberDaysFee,
                                                   double capitalBalance) {
    return (Math.pow((tiea + 1), (numberDaysFee / 360)) - 1) * capitalBalance;
  }

  /**
   * Cálculo del Seguro de desgravamen.
   * @param balanceMonth saldo de capital del mes.
   * @param insuranceRate tasa de seguro de desgravamen.
   * @return seguro de desgravamen.
   */
  public static double calculateCreditLifeInsurance(double balanceMonth, double insuranceRate) {
    return balanceMonth * insuranceRate;
  }

  /**
   * Cálculo de la cuota final.
   * @param monthlyFee cuota mensual a pagar sin gastos.
   * @param insuranceFee seguro de la cuota.
   * @return cuota final.
   */
  public static double calculateFinalFee(double monthlyFee, double insuranceFee) {
    return monthlyFee + insuranceFee;
  }

  /**
   * Cálculo de la Tasa de Costo Efectivo Anual.
   * @param TCEM tasa del costo efectivo mensual.
   * @return tasa del costo efectivo anual.
   */
  public static double calculateAnnualEffectiveCostRate(double TCEM) {
    return Math.pow((1 + TCEM), 12) - 1;
  }

  /**
   * Cálculo del interés compensatorio vencido por cuota.
   * @param interestRate tasa de interés del crédito.
   * @param numberDaysLate número de días de atraso.
   * @param monthlyFee Cuota mensual a pagar sin gastos.
   * @return interés compensatorio vencido.
   */
  public static double CalculateCompensatoryInterestDueFee(double interestRate,
                                                           double numberDaysLate,
                                                           double monthlyFee) {
    return (Math.pow((interestRate + 1), (numberDaysLate / 360)) - 1) * monthlyFee;
  }
}
