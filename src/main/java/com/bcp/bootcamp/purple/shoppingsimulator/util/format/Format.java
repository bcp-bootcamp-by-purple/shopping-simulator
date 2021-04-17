package com.bcp.bootcamp.purple.shoppingsimulator.util.format;

public class Format {

  /**
   * redondea un numero a la cantidad de decimales indicadas.
   * @param value numero a evaluar.
   * @param places cantidad de decimales.
   * @return numero formateado.
   */
  public static double roundNumber(double value, int places) {
    var scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;
  }
}
