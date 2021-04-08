package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.CountryRestController;
import com.warehouse_accounting.models.dto.CountryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql(value = "classpath:init-countries-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class CountryRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CountryRestController countryRestController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testExistence() {
        assertThat(countryRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        this.mockMvc.perform(get("/api/countries"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        this.mockMvc.perform(get("/api/countries/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.shortName").value("Россия"))
                .andExpect(jsonPath("$.longName").value("Российская Федерация"))
                .andExpect(jsonPath("$.code").value(643))
                .andExpect(jsonPath("$.codeOne").value("RU"))
                .andExpect(jsonPath("$.codeTwo").value("RUS"));
    }

    @Test
    void create() throws Exception {
        CountryDto countryDto = CountryDto.builder()
                .shortName("Марокко")
                .longName("Королевство Марокко")
                .code(BigInteger.valueOf(504))
                .codeOne("MA")
                .codeTwo("MAR")
                .build();
        String jsonProject = objectMapper.writeValueAsString(countryDto);

        this.mockMvc.perform(post("/api/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProject))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/api/countries/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("3"))
                .andExpect(jsonPath("$.shortName").value("Марокко"))
                .andExpect(jsonPath("$.longName").value("Королевство Марокко"))
                .andExpect(jsonPath("$.code").value(504))
                .andExpect(jsonPath("$.codeOne").value("MA"))
                .andExpect(jsonPath("$.codeTwo").value("MAR"));
    }

    @Test
    void update() throws Exception {
        CountryDto countryDto = CountryDto.builder()
                .id(1L)
                .shortName("Япония")
                .longName("Япония")
                .code(BigInteger.valueOf(392))
                .codeOne("JP")
                .codeTwo("JPN")
                .build();
        String jsonProject = objectMapper.writeValueAsString(countryDto);

        this.mockMvc.perform(put("/api/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProject))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/api/countries/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.shortName").value("Япония"))
                .andExpect(jsonPath("$.longName").value("Япония"))
                .andExpect(jsonPath("$.code").value(392))
                .andExpect(jsonPath("$.codeOne").value("JP"))
                .andExpect(jsonPath("$.codeTwo").value("JPN"));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/countries/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/countries/1"))
                .andExpect(status().isNotFound());
    }
}