package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.PaymentRestController;
import com.warehouse_accounting.models.Payment;
import com.warehouse_accounting.repositories.PaymentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional

//@Sql(value = {"classpath:init-payments-table-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"classpath:init-payments-table-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class PaymentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaymentRestController controller;

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
    void testExistence() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/payments"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        Payment payment = new Payment(100L, "100", null, null,
                null, null, false, "testCreate", null,
                null, null, null, null, null,
                null, null);

        mockMvc.perform(post("/api/payments", payment)
                        .content(objectMapper.writeValueAsString(payment))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void getById() throws Exception {
        Payment payment = createPayment("200");

        mockMvc.perform(get("/api/payments/{id}", payment.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("number").value("200"))
                .andExpect(jsonPath("comment").value("test"));
    }

    @Test
    void update() throws Exception {
        Payment payment = createPayment("300");

        mockMvc.perform(get("/api/payments/{id}", payment.getId()))
                .andDo(print())
                .andExpect(status().isOk());

        payment.setNumber("400");
        payment.setComment("Updating");

        mockMvc.perform(put("/api/payments")
                        .content(objectMapper.writeValueAsString(payment))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/payments/{id}", payment.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("comment").value("Updating"))
                .andExpect(jsonPath("number").value("400"));
    }

    @Test
    void deleteById() throws Exception {
        Payment payment = createPayment("500");
        Long id = payment.getId();

        mockMvc.perform(get("/api/payments/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/payments/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/payments/{id}", id))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    private Payment createPayment(String number) {
        Payment payment = new Payment(null, number, null, null,
                null, null, false, "test", null,
                null, null, null, null, null,
                null, null);
        return repository.save(payment);
    }
}