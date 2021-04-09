package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.ProductionOrderController;
import com.warehouse_accounting.models.dto.ProductionOrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest   //поднимает контекст целиком.
@AutoConfigureMockMvc   //Эта аннотация нужна для того, чтобы появилась возможность внедрить в тестовый класс бин MockMvc
@Sql(value = {"classpath:init-production_order-table.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ProductionOrderRestControllerTest {

    @Autowired
    private ObjectMapper objectMapper;   //Этот класс преобразовывает объект в JSON-строку

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductionOrderController productionOrderController;

    @Test
    void testExistence() {
        assertThat(productionOrderController).isNotNull();
    }

    @Test
    void givenAllProductionOrderDto_whenGetALL_thenStatus201andAllProductionOrderDtoReturned() throws Exception {
        mockMvc.perform(get("/api/production_order"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void givenId_whenGetExistingProductionOrderDto_thenStatus200andProductionOrderDtoReturned() throws Exception {
        mockMvc.perform(
                get("/api/production_order/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.number").value("500"));
    }

    @Test
    public void givenProductionOrderDto_whenAdd_thenStatus201andProductionOrderDtoReturned() throws Exception {
        ProductionOrderDto productionOrderDto1 = ProductionOrderDto.builder()
                .id(2L)
                .number("number")
                .dateTime(LocalDateTime.of(2021, 1, 1, 0, 0, 0))
                .companyId(1L)
                .companyName("name")
                .technologicalMapId(1L)
                .technologicalMapName("Techmap")
                .volumeOfProduction(new BigDecimal(100))
                .warehouseId(1L)
                .warehouseName("Основной склад")
                .planDate(LocalDate.of(2021, 1, 1))
                .projectId(5L)
                .projectName("null")
                .comment("comment")
                .build();

        mockMvc.perform(post("/api/production_order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productionOrderDto1)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/production_order/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.number").value("number"));
    }

    @Test
    public void giveProductionOrderDto_whenUpdate_thenStatus200andUpdatedReturns() throws Exception {
        ProductionOrderDto productionOrderDto = ProductionOrderDto.builder()
                .id(1L)
                .number("99")
                .dateTime(LocalDateTime.of(2021, 1, 1, 0, 0, 0))
                .companyId(1L)
                .companyName("name")
                .technologicalMapId(1L)
                .technologicalMapName("name")
                .volumeOfProduction(new BigDecimal(100))
                .warehouseId(1L)
                .warehouseName("Основной склад")
                .planDate(LocalDate.of(2021, 1, 1))
                .projectId(5L)
                .projectName("name")
                .comment("comment here")
                .build();

        mockMvc.perform(put("/api/production_order")
                .content(objectMapper.writeValueAsString(productionOrderDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/production_order/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productionOrderDto)));
    }

    @Test
    public void givenProductionOrderDto_whenDeleteProductionOrderDto_thenStatus200() throws Exception {
        mockMvc.perform(delete("/api/production_order/1"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/api/production_order/1"))
                .andExpect(status().isNotFound());
    }
}
