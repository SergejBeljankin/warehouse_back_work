package com.warehouse_accounting.integration_tests;

import com.warehouse_accounting.controllers.rest.TechnologicalMapGroupRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test for {@link TechnologicalMapGroupRestController}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 04.04.2021
 */

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql(value = "classpath:init-technological-map-group-table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class TechnologicalMapGroupRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TechnologicalMapGroupRestController technologicalMapGroupRestController;

    @Test
    void testExistence() {
        assertThat(technologicalMapGroupRestController).isNotNull();
    }
}
