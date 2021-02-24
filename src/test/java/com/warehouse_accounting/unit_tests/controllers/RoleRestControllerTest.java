package com.warehouse_accounting.unit_tests.controllers;

import com.warehouse_accounting.controllers.rest.RoleRestController;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.RoleService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRestControllerTest {

    @InjectMocks
    private RoleRestController roleRestController;

    @Mock
    private RoleService roleService;

    @Mock
    private CheckEntityService checkEntityService;

    @Test
    void getAll() {
        ResponseEntity<List<RoleDto>> responseEntity = roleRestController.getAll();
        Assert.notNull(responseEntity.getBody(), "а тут вылез null");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Mockito.verify(roleService, Mockito.times(1))
                .getAll();
    }

    @Test
    void getById() {
        ResponseEntity<RoleDto> roleDtoResponseEntity = roleRestController.getById((long) 1);
        assertEquals(roleDtoResponseEntity.getStatusCode(), HttpStatus.OK);
        Mockito.verify(checkEntityService, Mockito.times(1))
                .checkExistRoleById(ArgumentMatchers.eq((long) 1));
        Mockito.verify(roleService, Mockito.times(1))
                .getById(ArgumentMatchers.eq((long) 1));
    }

    @Test
    void create() {
        RoleDto roleDto = new RoleDto();
        assertEquals(roleRestController.create(roleDto).getStatusCode(), HttpStatus.OK);
        Mockito.verify(roleService, Mockito.times(1))
                .create(ArgumentMatchers.eq(roleDto));
    }

    @Test
    void update() {
        RoleDto roleDto = new RoleDto();
        assertEquals(roleRestController.update(roleDto).getStatusCode(), HttpStatus.OK);
        Mockito.verify(roleService, Mockito.times(1))
                .update(ArgumentMatchers.eq(roleDto));
    }

    @Test
    void deleteById() {
        assertEquals(roleRestController.deleteById((long) 999).getStatusCode(), HttpStatus.OK);
        Mockito.verify(roleService, Mockito.times(1))
                .deleteById(ArgumentMatchers.eq((long) 999));
    }
}