package com.warehouse_accounting.controllers.rest;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.warehouse_accounting.models.RecycleBin;
import com.warehouse_accounting.repositories.RecycleBinRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MimeType;
import springfox.documentation.service.MediaTypes;

import java.util.*;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = PRIVATE, makeFinal = true)
//@WithMockUser(authorities = "ADMIN")
class RecycleBinRestControllerTest {

    MockMvc mockMvc;

    RecycleBinRepository recycleBinRepository;

    ObjectMapper objectMapper;

    @NonFinal
    RecycleBin recycleBin;
    @NonFinal
    UUID id;

    @BeforeEach
    void setUp() {
        recycleBin = new RecycleBin("document", new Date(), Collections.emptyList());
        id = recycleBinRepository
                .save(recycleBin)
                .getId();
    }

    @AfterEach
    void tearDown() {
        recycleBinRepository.deleteById(id);
    }

    @DisplayName("Getall works correctly")
    @Test
    @SneakyThrows
    void getAll() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recycle-bin"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(mvcResult -> Assertions.assertTrue(Objects
                        .requireNonNull(mvcResult.getResponse().getContentType())
                        .startsWith("application/json")));
    }

    @DisplayName("Getbyid works correctly")
    @Test
    @SneakyThrows
    void getById() {
        mockMvc.perform(get("/api/recycle-bin/" + id.toString()))
                .andExpect(status().isOk())
                .andExpect(mvcResult -> Assertions.assertTrue(Objects
                        .requireNonNull(mvcResult.getResponse().getContentType())
                        .startsWith("application/json")));
    }

    @DisplayName("Update works correctly")
    @Test
    @SneakyThrows
    void update() {
        mockMvc.perform(put("/api/recycle-bin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recycleBin)))
                .andExpect(status().isOk());
    }

    @DisplayName("Deletebyid works correctly")
    @Test
    @SneakyThrows
    void deleteById() {
        mockMvc.perform(delete("/api/recycle-bin/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/recycle-bin/1"))
                .andExpect(status().isNotFound());
    }
}
