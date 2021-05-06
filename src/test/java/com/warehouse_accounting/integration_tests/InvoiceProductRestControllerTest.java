package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.InvoiceProductRestController;
import com.warehouse_accounting.models.dto.InvoiceProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase

@Sql(value = "classpath:init-invoice_products-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)


public class InvoiceProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InvoiceProductRestController invoiceProductRestController;

    @Test
    void testExistence() {
        assertThat(invoiceProductRestController).isNotNull();
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/api/invoice_products"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetById() throws Exception {
        mockMvc.perform(get("/api/invoice_products"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/invoice_products/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        InvoiceProductDto invoiceProductDto = InvoiceProductDto.builder()
                .id(2L)
                .count(BigDecimal.valueOf(200))
                .price(BigDecimal.valueOf(200))
                .build();

        String jsonRole = new ObjectMapper().writeValueAsString(invoiceProductDto);

        mockMvc.perform(post("/api/invoice_products")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonRole))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/invoice_products/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.count").value("200"))
                .andExpect(jsonPath("$.price").value("200"));

    }

    @Test
    public void update() throws Exception {
        InvoiceProductDto requiredInvoiceProduct = InvoiceProductDto.builder()
                .id(3L)
                .count(BigDecimal.valueOf(10000))
                .price(BigDecimal.valueOf(10000))
                .build();

        String jsonRole = new ObjectMapper().writeValueAsString(requiredInvoiceProduct);

        mockMvc.perform(put("/api/invoice_products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRole))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/invoice_products/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value("10000"))
                .andExpect(jsonPath("$.price").value("10000"));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(get("/api/invoice_products"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/invoice_products/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/invoice_products/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}