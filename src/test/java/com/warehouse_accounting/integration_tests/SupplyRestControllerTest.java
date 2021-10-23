package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.SupplyRestController;
import com.warehouse_accounting.models.dto.SupplyDto;
import com.warehouse_accounting.services.interfaces.SupplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SupplyRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SupplyRestController supplyRestController;

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void TestExist() {
        assertThat(supplyRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception{
        mockMvc.perform(get("/api/supplys"))
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception{
        mockMvc.perform(get("/api/supplys/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.comment").value("text"))
                .andExpect(jsonPath("$.contractId").value("1"))
                .andExpect(jsonPath("$.sum").value(BigDecimal.valueOf(555.00)));
    }

    @Test
    void create() throws Exception{
       SupplyDto supplyDto2 = SupplyDto.builder()
                .id(2L)
                .dateOfCreation(LocalDateTime.now())
                .contractId(1L)
                .contractorId(1L)
                .companyId(1L)
                .sum(BigDecimal.valueOf(11111))
                .isSent(false)
                .isPrinted(true)
                .comment("create")
                .build();
        SupplyDto supplyDto3 = SupplyDto.builder()
                .id(3L)
                .comment("forDelete")
                .build();


        mockMvc.perform(post("/api/supplys")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(supplyDto2)))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/supplys")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(supplyDto3)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/supplys/2"))
                .andDo(print())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.comment").value("create"))
                .andExpect(jsonPath("$.contractId").value("1"))
                .andExpect(jsonPath("$.isPrinted").value(true))
                .andExpect(jsonPath("$.sum").value(BigDecimal.valueOf(11111.0)))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception{

        SupplyDto supplyDto = supplyService.getById(2L);
        supplyDto.setComment("update");
        supplyDto.setSum(BigDecimal.valueOf(345));

        mockMvc.perform(get("/api/supplys/2"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/supplys")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(supplyDto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/supplys/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(supplyDto)));
    }

    @Test
    void delete() throws Exception{


        mockMvc.perform(MockMvcRequestBuilders.delete("/api/supplys/3"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/supplys/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}