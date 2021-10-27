package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.ShipmentRestController;
import com.warehouse_accounting.models.dto.ShipmentDto;
import com.warehouse_accounting.services.interfaces.ShipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ShipmentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShipmentRestController shipmentRestController;

    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void TestExist() {
        assertThat(shipmentRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/shipments"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/shipments/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.comment").value("Shipment"))
                .andExpect(jsonPath("$.contractId").value("1"))
                .andExpect(jsonPath("$.deliveryAddress").value("To the moon"))
                .andExpect(jsonPath("$.sum").value(BigDecimal.valueOf(777.00)));
    }

    @Test
    void create() throws Exception {
        ShipmentDto shipmentDto2 = ShipmentDto.builder()
                .id(2L)
                .dateOfCreation(LocalDateTime.now())
                .warehouseId(1L)
                .contractorId(1L)
                .contractId(1L)
                .companyId(1L)
                .sum(BigDecimal.valueOf(11111))
                .isSent(false)
                .isPrinted(true)
                .comment("create")
                .deliveryAddress("qqwwee")
                .build();
        ShipmentDto shipmentDto3 = ShipmentDto.builder()
                .id(3L)
                .comment("forDelete")
                .build();
        mockMvc.perform(post("/api/shipments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(shipmentDto2)))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/shipments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(shipmentDto3)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/shipments/2"))
                .andDo(print())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.comment").value("create"))
                .andExpect(jsonPath("$.contractId").value("1"))
                .andExpect(jsonPath("$.isPrinted").value(true))
                .andExpect(jsonPath("$.sum").value(BigDecimal.valueOf(11111.0)))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        ShipmentDto shipmentDto = shipmentService.getById(2L);
        shipmentDto.setComment("update");
        shipmentDto.setDeliveryAddress("A");

        mockMvc.perform(get("/api/shipments/2"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/shipments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(shipmentDto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/shipments/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(shipmentDto)));
    }
    @Test
    void delete() throws Exception{


        mockMvc.perform(MockMvcRequestBuilders.delete("/api/shipments/3"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/shipments/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}