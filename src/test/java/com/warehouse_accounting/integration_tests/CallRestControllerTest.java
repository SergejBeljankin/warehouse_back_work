package com.warehouse_accounting.integration_tests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.CallRestController;
import com.warehouse_accounting.models.Call;
import com.warehouse_accounting.models.dto.CallDto;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;
import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.services.interfaces.CallService;
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


import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@Transactional
@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureTestDatabase
//@Sql(value = {"classpath:init-calls-table.sql"
//        , "classpath:init-employees-table.sql"}
//        , executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
//)

public class CallRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CallRestController callRestController;

    @Autowired
    private CallService callService;

    @Autowired
    private ObjectMapper objectMapper;

    private  CallDto callDto;

    @Test
    void testExist() {
        assertThat(callRestController).isNotNull();
    }

    @Test
    void testGetAll() throws Exception {


        mockMvc.perform(get("/api/calls"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetById() throws Exception {
        mockMvc.perform(get("/api/calls/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.comment").value("comment"));
    }

    @Test
    void testCreate() throws Exception {


        CallDto callDto = CallDto.builder()
                .type("sometype")
                .number(10500L)
                .comment("othercomment")
                .employeeWhoCalledId(1L)
                .employeeWhoChangedId(1L)
                .build();

        String jsonCall = new ObjectMapper().writeValueAsString(callDto);

        mockMvc.perform(post("/api/calls")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCall))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/calls/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("sometype"))
                .andExpect(jsonPath("$.comment").value("othercomment"));
    }

    @Test
    void testUpdate() throws Exception {
        CallDto callDto = callService.getById(2L);

        callDto.setComment("New name for Test");
        callDto.setCallRecord("New record");

        mockMvc.perform(get("/api/calls/2"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/calls")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(callDto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/calls/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(callDto)));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(get("/api/calls/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/calls/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/calls/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
