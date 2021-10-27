package com.warehouse_accounting.unit_tests.controllers;

import com.warehouse_accounting.controllers.rest.RoleRestController;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.RoleService;
import org.junit.jupiter.api.BeforeAll;
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
import static org.mockito.Mockito.when;

@SpringBootTest
class RoleRestControllerTest {

    private static RoleDto roleDto1;
    private static RoleDto roleDto2;
    private static List<RoleDto> roleDtoList;

    @InjectMocks
    private RoleRestController roleRestController;

    @Mock
    private RoleService roleService;

    @Mock
    private CheckEntityService checkEntityService;

    @Mock
    private RoleRepository repository;

    @BeforeAll
    static void initMethod() {
        roleDto1 = RoleDto.builder()
                .id((long) 1)
                .sortNumber("1")
                .name("first")
                .build();
        roleDto2 = RoleDto.builder()
                .id((long) 2)
                .sortNumber("2")
                .name("second")
                .build();
        roleDtoList = List.of(roleDto1, roleDto2);
    }

    @Test
    void getAll() {
        when(roleService.getAll()).thenReturn(roleDtoList);
        ResponseEntity<List<RoleDto>> responseEntity = roleRestController.getAll();
        Assert.notNull(responseEntity.getBody(), "а тут вылез null");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody(), roleDtoList);
        Mockito.verify(roleService, Mockito.times(1))
                .getAll();
    }

    @Test
    void getById() {
        when(roleService.getById((long) 1)).thenReturn(roleDto1);
        ResponseEntity<RoleDto> roleDtoResponseEntity = roleRestController.getById((long) 1);
        assertEquals(roleDtoResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(roleDtoResponseEntity.getBody(), roleDto1);
        Mockito.verify(checkEntityService, Mockito.times(1))
                .checkExist(ArgumentMatchers.eq((long) 1), repository, "Role");
        Mockito.verify(roleService, Mockito.times(1))
                .getById(ArgumentMatchers.eq((long) 1));
    }

    @Test
    void create() {
        assertEquals(roleRestController.create(roleDto1).getStatusCode(), HttpStatus.OK);
        Mockito.verify(roleService, Mockito.times(1))
                .create(ArgumentMatchers.eq(roleDto1));
    }

    @Test
    void update() {
        assertEquals(roleRestController.update(roleDto2).getStatusCode(), HttpStatus.OK);
        Mockito.verify(roleService, Mockito.times(1))
                .update(ArgumentMatchers.eq(roleDto2));
    }

    @Test
    void deleteById() {
        assertEquals(roleRestController.deleteById((long) 999).getStatusCode(), HttpStatus.OK);
        Mockito.verify(roleService, Mockito.times(1))
                .deleteById(ArgumentMatchers.eq((long) 999));
    }
}