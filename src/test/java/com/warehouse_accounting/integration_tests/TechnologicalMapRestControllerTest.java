package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.TechnologicalMapRestController;
import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto;
import com.warehouse_accounting.models.dto.TechnologicalMapProductDto;
import com.warehouse_accounting.services.interfaces.TechnologicalMapService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration test for {@link TechnologicalMapRestController}
 * SQL не требуется.
 * Все начальные данные генерируется в {@link com.warehouse_accounting.configs.DataInitializer},
 * либо непосредственно в тесте, создаются, отправляются и получаются
 * @author pavelsmirnov
 * @version 0.1
 * Created 03.04.2021
 */

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
//@Sql(value = "classpath:init-technological-map-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class TechnologicalMapRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TechnologicalMapRestController technologicalMapRestController;

    @Autowired
    private TechnologicalMapService technologicalMapService;

    @Autowired
    private ObjectMapper objectMapper;

//    private static final List<TechnologicalMapDto> technologicalMapDtos = new ArrayList<>();
//    private static final List<TechnologicalMapProductDto> productDtos = new ArrayList<>();
//    private static final List<TechnologicalMapMaterialDto> materialDtos = new ArrayList<>();

//    @BeforeAll
//    static void init() {
//        TechnologicalMapDto technologicalMapDto =
//                TechnologicalMapDto.builder()
//                        .id(1L)
//                        .name("Изготовление газировки")
//                        .productionCost(BigDecimal.valueOf(100500))
//                        .isArchived(false)
//                        .comment("Секретный рецепт производства газировки")
//                        .materials(null)
//                        .finishedProducts(null)
//                        .technologicalMapGroupId(1L)
//                        .build();
//
//        materialDtos.add(new TechnologicalMapMaterialDto().builder()
//                .id(1L)
//                .materialId(1L)
//                .materialName("Вода")
//                .count(BigDecimal.valueOf(2))
//                .technologicalMapDto(technologicalMapDto)
//                .build());
//        materialDtos.add(new TechnologicalMapMaterialDto().builder()
//                .id(2L)
//                .materialId(2L)
//                .materialName("Газ в балоне")
//                .count(BigDecimal.valueOf(1))
//                .technologicalMapDto(technologicalMapDto)
//                .build());
//        materialDtos.add(new TechnologicalMapMaterialDto().builder()
//                .id(3L)
//                .materialId(3L)
//                .materialName("Бутылка стеклянная")
//                .count(BigDecimal.valueOf(1))
//                .technologicalMapDto(technologicalMapDto)
//                .build());
//
//        productDtos.add(new TechnologicalMapProductDto().builder()
//                .id(1L)
//                .finishedProductId(4L)
//                .finishedProductsName("Газировка")
//                .count(BigDecimal.valueOf(1))
//                .technologicalMapDto(technologicalMapDto)
//                .build());
//
//        technologicalMapDto.setMaterials(materialDtos);
//        technologicalMapDto.setFinishedProducts(productDtos);
//
//        technologicalMapDtos.addAll(Collections.singletonList(technologicalMapDto));
//    }

    @Test
    void testExistence() {
        assertThat(technologicalMapRestController).isNotNull();
    }

    @Test
    void testGetAll() throws Exception {
        this.mockMvc.perform(get("/api/technological_map"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetById() throws Exception {
        mockMvc.perform(get("/api/technological_map/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Изготовление газировки"))
                .andExpect(jsonPath("$.productionCost").value("100500.0"));
    }

    @Test
    void testCreate() throws Exception {
        TechnologicalMapDto technologicalMapDto = TechnologicalMapDto.builder()
                .name("test")
                .productionCost(BigDecimal.valueOf(0))
                .isArchived(false)
                .comment("passed")
                .materials(null)
                .finishedProducts(null)
                .technologicalMapGroupId(2L)
                .build();
        String jsonRole = new ObjectMapper().writeValueAsString(technologicalMapDto);

        mockMvc.perform(post("/api/technological_map")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRole))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_map/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.comment").value("passed"));
    }

    @Test
    void testUpdate() throws Exception {

        TechnologicalMapDto technologicalMapDto = technologicalMapService.getById(2L);

        technologicalMapDto.setName("New name for Test");

        mockMvc.perform(get("/api/technological_map/2"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/technological_map")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(technologicalMapDto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_map/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(technologicalMapDto)));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(get("/api/technological_map/2"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/technological_map/2"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/technological_map/2"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
