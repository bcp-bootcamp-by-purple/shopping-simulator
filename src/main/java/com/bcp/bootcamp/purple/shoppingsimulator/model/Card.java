package com.bcp.bootcamp.purple.shoppingsimulator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String type;
}
