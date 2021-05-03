package com.warehouse_accounting.controllers.rest;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jayway.jsonpath.JsonPath;
import com.warehouse_accounting.models.RecycleBin;
import com.warehouse_accounting.repositories.RecycleBinRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
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

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(level = PRIVATE, makeFinal = true)
//@WithMockUser(authorities = "ADMIN")
class RecycleBinRestControllerTest {

    MockMvc mockMvc;

    RecycleBinRepository recycleBinRepository;

    static UUID id;

    @BeforeEach
    private void init() {
        if (id == null)
            id = recycleBinRepository
                    .save(new RecycleBin("document", new Date(), List.of()))
                    .getId();
    }

    @DisplayName("Getall works correctly")
    @Test
    @SneakyThrows
    void getAll() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recycleBin"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(mvcResult -> Assertions.assertTrue(Objects
                        .requireNonNull(mvcResult.getResponse().getContentType())
                        .startsWith("application/json")));
    }

}