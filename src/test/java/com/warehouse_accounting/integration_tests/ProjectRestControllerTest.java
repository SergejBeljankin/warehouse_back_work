package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.ProjectRestController;
import com.warehouse_accounting.models.dto.ProjectDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql(value = "classpath:init-project-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ProjectRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProjectRestController projectRestController;

    private static ObjectMapper objectMapper;

    @BeforeAll
    static void init() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testExistence() {
        assertThat(projectRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        this.mockMvc.perform(get("/api/projects"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        this.mockMvc.perform(get("/api/projects/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Test1"))
                .andExpect(jsonPath("$.code").value("test"))
                .andExpect(jsonPath("$.description").value("test"));
    }

    @Test
    void create() throws Exception {
        ProjectDto projectDto = ProjectDto.builder()
                .name("Test2")
                .code("test2")
                .description("test2")
                .build();
        String jsonProject = objectMapper.writeValueAsString(projectDto);

        this.mockMvc.perform(post("/api/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProject))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/api/projects/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.name").value("Test2"))
                .andExpect(jsonPath("$.code").value("test2"))
                .andExpect(jsonPath("$.description").value("test2"));

    }

    @Test
    void update() throws Exception {
        ProjectDto projectDto = ProjectDto.builder()
                .id(1L)
                .name("new Test")
                .code("test")
                .description("test")
                .build();
        String jsonProject = objectMapper.writeValueAsString(projectDto);

        this.mockMvc.perform(put("/api/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProject))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/api/projects/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("new Test"))
                .andExpect(jsonPath("$.code").value("test"))
                .andExpect(jsonPath("$.description").value("test"));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/projects/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/projects/1"))
                .andExpect(status().isNotFound());
    }
}