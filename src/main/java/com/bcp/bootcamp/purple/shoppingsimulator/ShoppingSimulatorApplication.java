package com.bcp.bootcamp.purple.shoppingsimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ShoppingSimulatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShoppingSimulatorApplication.class, args);
  }

}
