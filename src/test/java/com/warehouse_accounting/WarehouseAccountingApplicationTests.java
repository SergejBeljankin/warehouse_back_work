package com.warehouse_accounting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.RoleRestController;
import com.warehouse_accounting.models.dto.RoleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql(value = "classpath:init-role-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class WarehouseAccountingApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private RoleRestController roleRestController;

    @Test
    void testExistence() {
        assertThat(roleRestController).isNotNull();
    }

    //    @WithMockUser("someUser")
    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/api/role"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //    @WithMockUser("someUser")
    @Test
    void testGetById() throws Exception {
        mockMvc.perform(get("/api/role/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("5"))
                .andExpect(jsonPath("$.name").value("dummy_user"))
                .andExpect(jsonPath("$.sortNumber").value("5"));
    }

    //    @WithMockUser("someUser")
    @Test
    void testCreate() throws Exception {
        RoleDto requiredRole = RoleDto.builder()
                .name("dummy_user_3")
                .sortNumber("800").build();
        String jsonRole = new ObjectMapper().writeValueAsString(requiredRole);

        mockMvc.perform(post("/api/role")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRole))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/role/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("dummy_user_3"))
                .andExpect(jsonPath("$.sortNumber").value("800"));
    }

    //    @WithMockUser("someUser")
    @Test
    void testUpdate() throws Exception {
        RoleDto requiredRole = RoleDto.builder()
                .id((long) 9)
                .name("dummy_user_2_new")
                .sortNumber("900").build();
        String jsonRole = new ObjectMapper().writeValueAsString(requiredRole);

        mockMvc.perform(put("/api/role")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRole))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/role/9"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("dummy_user_2_new"))
                .andExpect(jsonPath("$.sortNumber").value("900"));
    }

    //    @WithMockUser("someUser")
    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/role/9"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/role/9"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
