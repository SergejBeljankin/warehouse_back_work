package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.ProductGroupRestController;
import com.warehouse_accounting.models.dto.ProductGroupDto;
import com.warehouse_accounting.services.interfaces.ProductGroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductGroupRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductGroupRestController productGroupRestController;
    @Autowired
    private ProductGroupService productGroupService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testExist() {
        assertThat(productGroupRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/product_groups"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/product_groups/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.name").value("Product2"))
                .andExpect(jsonPath("$.sortNumber").value("242"))
                .andExpect(jsonPath("$.parentId").value(1));
    }

    @Test
    void create() throws Exception {
        ProductGroupDto dto = ProductGroupDto.builder()
                .id(4L)
                .name("TestProduct")
                .sortNumber("sortNumber")
                .parentId(1L)
                .build();

        String jsonProductGroup = new ObjectMapper().writeValueAsString(dto);
        mockMvc.perform(post("/api/product_groups")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonProductGroup))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/product_groups/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("4"))
                .andExpect(jsonPath("$.name").value("TestProduct"))
                .andExpect(jsonPath("$.sortNumber").value("sortNumber"))
                .andExpect(jsonPath("$.parentId").value(1));
    }

    @Test
    void update() throws Exception {
        ProductGroupDto dto = productGroupService.getById(1L);
        dto.setName("Update name");
        dto.setSortNumber("Update number");

        mockMvc.perform(get("/api/product_groups/1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/product_groups")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/product_groups/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(dto)));
    }

    @Test
    void deleteById() throws Exception {

        mockMvc.perform(delete("/api/product_groups/3"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/product_groups/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}