package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.CustomerReturnsRestController;
import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.CustomerReturnsDto;
import com.warehouse_accounting.models.dto.WarehouseDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CustomerReturnsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CustomerReturnsRestController customerReturnsRestController;
    @Autowired
    private ObjectMapper mapper;

    private static final List<CustomerReturnsDto> customerReturnsDtoList = new ArrayList<>();

    @BeforeAll
    static void initCustomerReturns() {
        CustomerReturnsDto customerReturnsDto1 = CustomerReturnsDto.builder()
                .id(1L)
                .date(LocalDateTime.now())
                .warehouseDto(WarehouseDto.builder().build())
                .contractDto(ContractDto.builder().build())
                .contractorDto(ContractorDto.builder().build())
                .companyDto(CompanyDto.builder().build())
                .productDtos(new ArrayList<>())
                .taskDtos(new ArrayList<>())
                .fileDtos(new ArrayList<>())
                .sum(BigDecimal.valueOf(10000))
                .isPaid(true)
                .isSend(false)
                .comment("Возврат оформлен")
                .build();

        CustomerReturnsDto customerReturnsDto2 = CustomerReturnsDto.builder()
                .id(2L)
                .date(LocalDateTime.now().minusDays(10))
                .warehouseDto(WarehouseDto.builder().build())
                .contractDto(ContractDto.builder().build())
                .contractorDto(ContractorDto.builder().build())
                .companyDto(CompanyDto.builder().build())
                .productDtos(new ArrayList<>())
                .taskDtos(new ArrayList<>())
                .fileDtos(new ArrayList<>())
                .sum(BigDecimal.valueOf(50000))
                .isPaid(false)
                .isSend(false)
                .comment("Возврат не оформлен")
                .build();

        CustomerReturnsDto customerReturnsDto3 = CustomerReturnsDto.builder()
                .id(3L)
                .date(LocalDateTime.now().plusMonths(3))
                .warehouseDto(WarehouseDto.builder().build())
                .contractDto(ContractDto.builder().build())
                .contractorDto(ContractorDto.builder().build())
                .companyDto(CompanyDto.builder().build())
                .productDtos(new ArrayList<>())
                .taskDtos(new ArrayList<>())
                .fileDtos(new ArrayList<>())
                .sum(BigDecimal.valueOf(700000))
                .isPaid(true)
                .isSend(true)
                .comment("Возврат оформлен, ожидается возврат средств")
                .build();

        customerReturnsDtoList.addAll(Arrays.asList(customerReturnsDto1, customerReturnsDto2, customerReturnsDto3));
    }

    @Test
    void testExistence() {
        assertThat(customerReturnsRestController).isNotNull();
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/api/customerreturns"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(customerReturnsDtoList)));
    }

    @Test
    void testGetById() throws Exception {
        mockMvc.perform(get("/api/customerreturns/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(customerReturnsDtoList.get(0))));
    }

    @Test
    void testCreate() throws Exception {
        CustomerReturnsDto customerReturnsDto4 = CustomerReturnsDto.builder()
                .id(4L)
                .date(LocalDateTime.now().plusMonths(5))
                .warehouseDto(WarehouseDto.builder().build())
                .contractDto(ContractDto.builder().build())
                .contractorDto(ContractorDto.builder().build())
                .companyDto(CompanyDto.builder().build())
                .productDtos(new ArrayList<>())
                .taskDtos(new ArrayList<>())
                .fileDtos(new ArrayList<>())
                .sum(BigDecimal.valueOf(0))
                .isPaid(false)
                .isSend(false)
                .comment("Возврат невозможен")
                .build();
        customerReturnsDtoList.add(customerReturnsDto4);

        mockMvc.perform(post("/api/customerreturns")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(customerReturnsDto4)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/customerreturns/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(customerReturnsDto4)));

        mockMvc.perform(get("/api/customerreturns"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(customerReturnsDtoList)));

        customerReturnsDtoList.remove(customerReturnsDto4);
    }

    @Test
    void testUpdate() throws Exception {
        CustomerReturnsDto customerReturnsDto1 = CustomerReturnsDto.builder()
                .id(1L)
                .date(LocalDateTime.now().minusDays(30))
                .warehouseDto(WarehouseDto.builder().build())
                .contractDto(ContractDto.builder().build())
                .contractorDto(ContractorDto.builder().build())
                .companyDto(CompanyDto.builder().build())
                .productDtos(new ArrayList<>())
                .taskDtos(new ArrayList<>())
                .fileDtos(new ArrayList<>())
                .sum(BigDecimal.valueOf(123123))
                .isPaid(true)
                .isSend(false)
                .comment("Возврат оформлен, в стадии отгрузки")
                .build();


        mockMvc.perform(put("/api/customerreturns")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(customerReturnsDto1)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/customerreturns/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(customerReturnsDto1)));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/customerreturns/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/customerreturns/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


}
