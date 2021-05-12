package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.AdjustmentRestController;
import com.warehouse_accounting.models.TypeOfAdjustment;
import com.warehouse_accounting.models.dto.AdjustmentDto;
import com.warehouse_accounting.services.interfaces.AdjustmentService;
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
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@Transactional
@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureTestDatabase
public class AdjustmentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdjustmentRestController adjustmentRestController;

    @Autowired
    private AdjustmentService adjustmentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void TestExist() {
        assertThat(adjustmentRestController).isNotNull();
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/api/adjustments"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetById() throws Exception {
        mockMvc.perform(get("/api/adjustments/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.comment").value("1 Корректировка"));
    }

    @Test
    void testCreate() throws Exception {
        AdjustmentDto adjustmentDto = AdjustmentDto.builder()

                .id(2L)
                .number("1234567")
//                .dateTimeAdjustment(LocalDateTime.now())
                .companyId(null)
                .contractorId(null)
//                .type(TypeOfAdjustment.CASHBALANCE)
//                    ACCOUNTBALANCE("Остаток на счете"),
//                    CASHBALANCE("Остаток в кассе"),
//                    COUNTERPARTY("Баланс контрагента");
//                .currentBalance(BigDecimal.valueOf(2000.00))
//                .totalBalance(BigDecimal.valueOf(1000.00))
//                .adjustmentAmount(BigDecimal.valueOf(1000.00))
                .comment("Новая корректировка")
//                .whenСhanged(LocalDateTime.now())
                .build();

        String jsonAdjustment = new ObjectMapper().writeValueAsString(adjustmentDto);
            mockMvc.perform(post("/api/adjustments")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonAdjustment))
                    .andExpect(status().isOk());

        mockMvc.perform(get("/api/adjustments/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value("1234567"))
                .andExpect(jsonPath("$.comment").value("Новая корректировка"));
    }

    @Test
    void testUpdate() throws Exception {

        AdjustmentDto adjustmentDto = adjustmentService.getById(2L);
        adjustmentDto.setNumber("875846784fghjgjkg");
        adjustmentDto.setComment("New comment for testUpdate");

        mockMvc.perform(get("/api/adjustments/2"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/adjustments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adjustmentDto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/adjustments/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(adjustmentDto)));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(get("/api/adjustments/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/adjustments/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/adjustments/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
