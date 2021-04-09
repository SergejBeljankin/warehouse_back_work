package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.TechnologicalOperationRestController;
import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql(value = {
        "classpath:init-company-table.sql",
        "classpath:init-project-table.sql",
        "classpath:init-warehouse-table.sql",
        "classpath:init-technological_operation-table.sql"
})
class TechnologicalOperationRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TechnologicalOperationRestController technologicalOperationRestController;

    @Autowired
    private ObjectMapper objectMapper;

    private static final List<TechnologicalOperationDto> technologicalOperationDtoList = new ArrayList<>();

    @BeforeAll
    static void init() {
        TechnologicalOperationDto technologicalOperationDtoFirst = TechnologicalOperationDto.builder()
                .id(1L)
                .number("number")
                .comments("comments")
                .isArchive(false)
                .companyId(1L)
                .companyName("companyName")
                .projectId(1L)
                .projectName("Test1")
                .technologicalOperationDateTime(null)
                .volumeOfProduction(BigDecimal.valueOf(1.1))
                .technologicalMapId(1L)
                .technologicalMapName("Изготовление газировки")
                .warehouseForMaterialsId(1L)
                .warehouseForMaterialsName("Основной склад")
                .warehouseForProductId(1L)
                .warehouseForProductName("Основной склад")
                .build();
        technologicalOperationDtoList.add(technologicalOperationDtoFirst);
    }

    @Test
    void testExistence() {
        assertThat(technologicalOperationRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        this.mockMvc.perform(get("/api/technological_operations"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(technologicalOperationDtoList)));
    }

    @Test
    void getById() throws Exception {
        this.mockMvc.perform(get("/api/technological_operations/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(technologicalOperationDtoList.get(0))));
    }

    @Test
    void create() throws Exception {
        TechnologicalOperationDto technologicalOperationDtoSecond = TechnologicalOperationDto.builder()
                .id(2L)
                .number("numberTwo")
                .comments("commentTwo")
                .isArchive(false)
                .companyId(1L)
                .companyName("companyName")
                .projectId(1L)
                .projectName("Test1")
                .technologicalOperationDateTime(null)
                .volumeOfProduction(BigDecimal.valueOf(2.2))
                .technologicalMapId(1L)
                .technologicalMapName("Изготовление газировки")
                .warehouseForMaterialsId(1L)
                .warehouseForMaterialsName("Основной склад")
                .warehouseForProductId(2L)
                .warehouseForProductName("Запасной склад")
                .build();

        technologicalOperationDtoList.add(technologicalOperationDtoSecond);

        mockMvc.perform(post("/api/technological_operations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(technologicalOperationDtoSecond)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_operations/2"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(technologicalOperationDtoList.get(1))));

        technologicalOperationDtoList.remove(technologicalOperationDtoSecond);
    }

    @Test
    void update() throws Exception {
        TechnologicalOperationDto technologicalOperationDtoFirst = TechnologicalOperationDto.builder()
                .id(1L)
                .number("update")
                .comments("comments")
                .isArchive(false)
                .companyId(1L)
                .companyName("companyName")
                .projectId(null)
                .projectName(null)
                .technologicalOperationDateTime(LocalDateTime.now())
                .volumeOfProduction(BigDecimal.valueOf(1.1))
                .technologicalMapId(1L)
                .technologicalMapName("Изготовление газировки")
                .warehouseForMaterialsId(1L)
                .warehouseForMaterialsName("Основной склад")
                .warehouseForProductId(1L)
                .warehouseForProductName("Основной склад")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/technological_operations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(technologicalOperationDtoFirst)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_operations/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(technologicalOperationDtoFirst)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/technological_operations/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_operations/1"))
                .andExpect(status().isNotFound());
    }
}
