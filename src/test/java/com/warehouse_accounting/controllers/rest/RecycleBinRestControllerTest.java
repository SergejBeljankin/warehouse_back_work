package com.warehouse_accounting.controllers.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.models.RecycleBin;
import com.warehouse_accounting.repositories.RecycleBinRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    Long id;

    @BeforeEach
    void setUp() {
        recycleBin = new RecycleBin(1L,"document","13",LocalDate.ofEpochDay(22), BigDecimal.valueOf(112) , "12","12","w" , "s" , "sa","w","g","wq");
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

