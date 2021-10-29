package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.ApplicationRestController;
import com.warehouse_accounting.models.dto.ApplicationDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ApplicationRestController controller;

    @Test
    void testExistence() throws Exception { assertThat(controller).isNotNull(); }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/applications"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/applications/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        ApplicationDto applicationDto = ApplicationDto.builder()
                .name("TestApp")
                .description("поставщиком компьютерного оборудования. " +
                        "Загрузка цен, остатков, описания и фото товара из каталога поставщика. " +
                        "Установка цен закупки.")
                .logoId(3L)
                .build();

        mockMvc.perform(post("/api/applications")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(applicationDto)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/applications/3"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(applicationDto)))
                .andExpect(jsonPath("$.id").value("3"))
                .andExpect(jsonPath("$.name").value("TestApp"));
    }

    @Test
    void update() throws Exception {
        ApplicationDto applicationDto = ApplicationDto.builder()
                .id(1l)
                .name("TestAppUpdated")
                .description("поставщиком компьютерного оборудования. " +
                        "Загрузка цен, остатков, описания и фото товара из каталога поставщика. " +
                        "Установка цен закупки.")
                .logoId(3L)
                .build();

        mockMvc.perform(put("/api/applications")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(applicationDto)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/applications/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(applicationDto)))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("TestAppUpdated"));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/applications/1"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/api/applications/1"))
                .andExpect(status().isNotFound());
    }
}
