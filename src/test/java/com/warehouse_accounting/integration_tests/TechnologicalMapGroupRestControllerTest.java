package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.TechnologicalMapGroupRestController;
import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;
import com.warehouse_accounting.services.interfaces.TechnologicalMapGroupService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration test for {@link TechnologicalMapGroupRestController}
 * SQL не требуется.
 * Все начальные данные генерируется в {@link com.warehouse_accounting.configs.DataInitializer},
 * либо непосредственно в тесте, создаются, отправляются и получаются
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 04.04.2021
 */

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
//@Sql(value = "classpath:init-technological-map-group-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class TechnologicalMapGroupRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TechnologicalMapGroupRestController technologicalMapGroupRestController;

    @Autowired
    private TechnologicalMapGroupService technologicalMapGroupService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testExistence() {
        assertThat(technologicalMapGroupRestController).isNotNull();
    }

    @Test
    void testGetAll() throws Exception {
        this.mockMvc.perform(get("/api/technological_map_group"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetById() throws Exception {
        mockMvc.perform(get("/api/technological_map_group/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.name").value("Группа 2"));
    }

    @Test
    void testCreate() throws Exception {
        TechnologicalMapGroupDto technologicalMapDto = TechnologicalMapGroupDto.builder()
                .name("TestGroup")
                .code("TST")
                .comment("Group for test Created Group")
                .build();
        String jsonRole = new ObjectMapper().writeValueAsString(technologicalMapDto);

        mockMvc.perform(post("/api/technological_map_group")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRole))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_map_group/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("TestGroup"))
                .andExpect(jsonPath("$.code").value("TST"));
    }

    @Test
    void testUpdate() throws Exception {
        TechnologicalMapGroupDto technologicalMapGroupDto = technologicalMapGroupService.getById(1L);

        technologicalMapGroupDto.setName("New name for Test");
        technologicalMapGroupDto.setCode("New code 123");

        mockMvc.perform(get("/api/technological_map_group/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/technological_map_group")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(technologicalMapGroupDto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_map_group/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(technologicalMapGroupDto)));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(get("/api/technological_map_group/3"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/technological_map_group/3"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_map_group/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
