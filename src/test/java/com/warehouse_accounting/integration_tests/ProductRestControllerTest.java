package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.ProductRestController;
import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.services.interfaces.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ProductRestControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRestController productRestController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testExistence() {
        assertThat(productRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {

        ProductDto productDto2 = ProductDto.builder()
                .id(5L)
                .name("Кола")
                .archive(false)
                .volume(BigDecimal.valueOf(20L))
                .weight(BigDecimal.valueOf(20L))
                .purchasePrice(BigDecimal.valueOf(20L))
                .description("Описание2")
                .unitDto(null)
                .productPricesDto(new ArrayList<>())
                .attributeOfCalculationObjectDto(null)
                .taxSystemDto(null)
                .contractorDto(null)
                .productGroupDto(null)
                .imagesDto(new ArrayList<>())
                .build();

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto2)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/products/5"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productDto2)))
                .andExpect(jsonPath("$.id").value("5"))
                .andExpect(jsonPath("$.name").value("Кола"));

    }

    @Test
    void update() throws Exception {

        ProductDto productDto3 = ProductDto.builder()
                .id(1L)
                .name("Фанта")
                .description("Другое описание")
                .volume(BigDecimal.valueOf(35L))
                .weight(BigDecimal.valueOf(40L))
                .purchasePrice(BigDecimal.valueOf(45L))
                .archive(true)
                .imagesDto(new ArrayList<>())
                .productPricesDto(new ArrayList<>())
                .build();

        mockMvc.perform(put("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto3)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productDto3)))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Фанта"));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isNotFound());
    }

}