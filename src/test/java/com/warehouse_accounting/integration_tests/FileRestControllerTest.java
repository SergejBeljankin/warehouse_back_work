package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.FileRestController;
import com.warehouse_accounting.models.dto.FileDto;
import com.warehouse_accounting.services.interfaces.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
public class FileRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FileRestController fileRestController;

    @Autowired
    private FileService fileService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testExistence() throws Exception {
        assertThat(fileRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/file"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/file/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1l))
                .andExpect(jsonPath("$.name").value("Product"))
                .andExpect(jsonPath("$.size").value(100))
                .andExpect(jsonPath("$.location").value("Japan"))
                .andExpect(jsonPath("$.date").value(null));

    }

    @Test
    void create() throws Exception {
        FileDto fileDto = FileDto.builder()
                .id(2l)
                .name("Zavoz")
                .size(300)
                .location("Russia")
                .createdDate(null)
                .employee(null)
                .build();

        String jsonFile = new ObjectMapper().writeValueAsString(fileDto);
        mockMvc.perform(post("/api/file")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonFile))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/file/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2l))
                .andExpect(jsonPath("$.name").value("Zavoz"))
                .andExpect(jsonPath("$.size").value(300))
                .andExpect(jsonPath("$.location").value("Russia"))
                .andExpect(jsonPath("$.date").value(null));
    }

    @Test
    void update() throws Exception {
        FileDto fileDto = fileService.getById(1l);
        fileDto.setName("Tovar");
        fileDto.setLocation("Germany");

        mockMvc.perform(get("/api/file/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/file")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fileDto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/file/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(fileDto)));
    }

    @Test
    void deleteById() throws Exception {

        mockMvc.perform(delete("/api/file/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/file/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
