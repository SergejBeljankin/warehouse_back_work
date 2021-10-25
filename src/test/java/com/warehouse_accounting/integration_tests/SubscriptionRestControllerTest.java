package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.SubscriptionRestController;
import com.warehouse_accounting.models.dto.SubscriptionDto;
import com.warehouse_accounting.services.interfaces.SubscriptionService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SubscriptionRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SubscriptionRestController subscriptionRestController;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testExist() {
        assertThat(subscriptionRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/subscription"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/subscription/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    void create() throws Exception {
        SubscriptionDto subscriptionDto = SubscriptionDto.builder()
                .id(2L)
                .subscriptionExpirationDate(null)
                .tariff(null)
                .employee(null)
                .requisites(null)
                .build();

        String jsonSubscription = new ObjectMapper().writeValueAsString(subscriptionDto);

        mockMvc.perform(post("/api/subscription")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonSubscription))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/subscription/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"));
    }

    @Test
    void update() throws Exception {
        Date newDate = DateUtils.addMonths(new Date(), 2);

        SubscriptionDto subscriptionDto = subscriptionService.getById(1L);
        subscriptionDto.setSubscriptionExpirationDate(newDate);


        mockMvc.perform(get("/api/subscription/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/subscription")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(subscriptionDto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/subscription/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(subscriptionDto)));
    }

    @Test
    void deleteById() throws Exception {

        mockMvc.perform(delete("/api/product_groups/3"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/product_groups/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
