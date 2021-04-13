package com.bcp.bootcamp.purple.shoppingsimulator.util.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum Status {

  SUCCESS("exitoso"),
  ERROR("error");

  private String value;
}
