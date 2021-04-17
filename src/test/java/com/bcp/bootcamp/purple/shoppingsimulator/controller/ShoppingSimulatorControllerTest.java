package com.bcp.bootcamp.purple.shoppingsimulator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bcp.bootcamp.purple.shoppingsimulator.model.Card;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Fees;
import com.bcp.bootcamp.purple.shoppingsimulator.model.PayDay;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationRequest;
import com.bcp.bootcamp.purple.shoppingsimulator.model.SimulationResponse;
import com.bcp.bootcamp.purple.shoppingsimulator.model.Tea;
import com.bcp.bootcamp.purple.shoppingsimulator.service.ShoppingSimulatorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ShoppingSimulatorControllerTest {

  @MockBean
  private ShoppingSimulatorService shoppingSimulatorService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
  }

  @Test
  void getCardTypes() throws Exception {

    var cardsMock = Arrays.asList(Card.builder().id(1).type("Clásica").build(),
      Card.builder().id(2).type("Oro").build(), Card.builder().id(1).type("Black").build());
    when(shoppingSimulatorService.getCardTypes()).thenReturn(cardsMock);
    MvcResult result = this.mockMvc
      .perform(MockMvcRequestBuilders.get("/v0/shopping-simulator/cards-types"))
      .andExpect(status().isOk())
      .andReturn();

    var content = result.getResponse().getContentAsString();
    var actual = this.objectMapper.readValue(content, new TypeReference<List<Card>>(){});

    assertEquals(cardsMock.get(1), actual.get(1));
  }

  @Test
  void getFees() throws Exception {

    var feesMock = Fees.builder().min(1).max(36).build();
    when(shoppingSimulatorService.getFees()).thenReturn(feesMock);
    MvcResult result = this.mockMvc
      .perform(MockMvcRequestBuilders.get("/v0/shopping-simulator/fees"))
      .andExpect(status().isOk())
      .andReturn();

    var content = result.getResponse().getContentAsString();
    var actual = this.objectMapper.readValue(content, Fees.class);

    assertEquals(feesMock, actual);
  }

  @Test
  void getPayDays() throws Exception {

    var payDaysMock = Arrays.asList(PayDay.builder().id(1).dayNumber(5).build(),
      PayDay.builder().id(1).dayNumber(5).build());
    when(shoppingSimulatorService.getPayDays()).thenReturn(payDaysMock);
    MvcResult result = this.mockMvc
      .perform(MockMvcRequestBuilders.get("/v0/shopping-simulator/pay-days"))
      .andExpect(status().isOk())
      .andReturn();

    var content = result.getResponse().getContentAsString();
    var actual = this.objectMapper.readValue(content, new TypeReference<List<PayDay>>(){});

    assertEquals(payDaysMock, actual);
  }

  @Test
  void getTeas() throws Exception {

    var teasMock = Arrays.asList(Tea.builder().id(1).value("99.90%").build(),
      Tea.builder().id(2).value("95.90%").build(), Tea.builder().id(3).value("90.90%").build());
    when(shoppingSimulatorService.getTeas()).thenReturn(teasMock);
    MvcResult result = this.mockMvc
      .perform(MockMvcRequestBuilders.get("/v0/shopping-simulator/teas"))
      .andExpect(status().isOk())
      .andReturn();

    var content = result.getResponse().getContentAsString();
    var actual = this.objectMapper.readValue(content, new TypeReference<List<Tea>>(){});

    assertEquals(teasMock, actual);
  }

  @Test
  void calculateShopping() throws Exception {

    var request = SimulationRequest.builder()
      .amount(2500.0)
      .card("CLASICA")
      .currency("S/")
      .dni("45654654")
      .fees(12)
      .tea("81.65%")
      .payDay("5").build();
    var expected = SimulationResponse.builder()
      .feesAmount(283.66)
      .currency("S/")
      .firstPaymentDate("5/5/2021")
      .status("exitoso").build();
    when(shoppingSimulatorService.calculateShopping(request)).thenReturn(expected);

    MvcResult result = this.mockMvc.perform( MockMvcRequestBuilders
      .post("/v0/shopping-simulator/calculation")
      .content(objectMapper.writeValueAsString(request))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andReturn();

    var content = result.getResponse().getContentAsString();
    var actual = this.objectMapper.readValue(content, SimulationResponse.class);

    assertEquals(expected, actual);
  }
}
