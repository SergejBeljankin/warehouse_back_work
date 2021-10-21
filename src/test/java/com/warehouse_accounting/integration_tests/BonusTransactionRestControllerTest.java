package com.warehouse_accounting.integration_tests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.BonusTransactionRestController;
import com.warehouse_accounting.models.BonusTransaction;
import com.warehouse_accounting.models.dto.BonusTransactionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql(value = "classpath:init-bonus_transaction-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class BonusTransactionRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BonusTransactionRestController bonusTransactionRestController;

    @Test
    void testExistence() {
        assertThat(bonusTransactionRestController).isNotNull();
    }

    @Test
    void testGetAll() throws Exception{
        mockMvc.perform(get("/api/bonus_transactions"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetById() throws Exception{
        mockMvc.perform(get("/api/bonus_transactions/6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("6"))
                .andExpect(jsonPath("$.created").value("2021-11-11T02:00:00"))
                .andExpect(jsonPath("$.transactionType").value("EARNING"))
                .andExpect(jsonPath("$.bonusValue").value("100"))
                .andExpect(jsonPath("$.transactionStatus").value("COMPLETED"))
                .andExpect(jsonPath("$.executionDate").value("2021-11-11T03:00:00"))
                .andExpect(jsonPath("$.bonusProgram").value("BEGINER"))
                .andExpect(jsonPath("$.comment").value("FOR CUPCAKES"));
    }

    @Test
    void testCreate() throws  Exception{
        BonusTransactionDto dto = BonusTransactionDto.builder()
                .transactionType(BonusTransaction.TransactionType.EARNING)
                .bonusValue(5L)
                .transactionStatus(BonusTransaction.TransactionStatus.COMPLETED)
                .bonusProgram("beginer")
                .comment("First Transaction!")
                .build();
        String jsonBonusTransaction = new ObjectMapper().writeValueAsString(dto);

        mockMvc.perform(post("/api/bonus_transactions/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBonusTransaction))
                .andExpect(status().isOk());
        mockMvc.perform(get("/api/bonus_transactions/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionType").value("EARNING"))
                .andExpect(jsonPath("$.bonusValue").value("5"))
                .andExpect(jsonPath("$.transactionStatus").value("COMPLETED"))
                .andExpect(jsonPath("$.bonusProgram").value("beginer"))
                .andExpect(jsonPath("$.comment").value("First Transaction!"));
    }

    @Test
    void TestUpdate() throws Exception{
        BonusTransactionDto dto = BonusTransactionDto.builder()
                .id(9L)
                .transactionType(BonusTransaction.TransactionType.EARNING)
                .bonusValue(5L)
                .transactionStatus(BonusTransaction.TransactionStatus.COMPLETED)
                .bonusProgram("beginer")
                .comment("First Transaction!")
                .build();
        String jsonBonusTransaction = new ObjectMapper().writeValueAsString(dto);

        mockMvc.perform(put("/api/bonus_transactions/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBonusTransaction))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/bonus_transactions/9"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionType").value("EARNING"))
                .andExpect(jsonPath("$.bonusValue").value("5"))
                .andExpect(jsonPath("$.transactionStatus").value("COMPLETED"))
                .andExpect(jsonPath("$.bonusProgram").value("beginer"))
                .andExpect(jsonPath("$.comment").value("First Transaction!"));

    }

    @Test
    void  testDelete() throws  Exception{
        mockMvc.perform(delete("/api/bonus_transactions/9"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/bonus_transactions/9"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
