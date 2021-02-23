package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.services.interfaces.RoleService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.List;


@SpringBootTest
class RoleServiceTest {

    @MockBean
    private RoleService roleService;

    @Test
    void getAll() {
        List<RoleDto> roleDtoList = roleService.getAll();
        Assert.notNull(roleDtoList, "а тут вылез null");
        Mockito.verify(roleService, Mockito.times(1))
                .getAll();
    }

    @Test
    void getById() {
        roleService.getById((long) 1);
        Mockito.verify(roleService, Mockito.times(1))
                .getById(ArgumentMatchers.eq((long) 1));

    }

    @Test
    void create() {
        RoleDto roleDto = new RoleDto();
        roleService.create(roleDto);
        Mockito.verify(roleService, Mockito.times(1))
                .create(ArgumentMatchers.eq(roleDto));
    }

    @Test
    void update() {
        RoleDto roleDto = new RoleDto();
        roleService.update(roleDto);
        Mockito.verify(roleService, Mockito.times(1))
                .update(ArgumentMatchers.eq(roleDto));
    }

    @Test
    void deleteById() {
        roleService.deleteById((long) 999);
        Mockito.verify(roleService, Mockito.times(1))
                .deleteById(ArgumentMatchers.eq((long) 999));
    }
}