package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.services.impl.RoleServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;


@SpringBootTest
class RoleServiceTest {

    @InjectMocks
    private RoleServiceImpl roleService;

    @Mock
    private RoleRepository roleRepository;

    @Test
    void getAll() {
        List<RoleDto> roleDtoList = roleService.getAll();
        Assert.notNull(roleDtoList, "а тут вылез null");
        Mockito.verify(roleRepository, Mockito.times(1))
                .getAll();
    }

    @Test
    void getById() {
        roleService.getById((long) 1);
        Mockito.verify(roleRepository, Mockito.times(1))
                .getById(ArgumentMatchers.eq((long) 1));

    }

    @Test
    void create() {
        RoleDto roleDto = new RoleDto();
        Role role = ConverterDto.convertToModel(roleDto);
        roleService.create(roleDto);
        Mockito.verify(roleRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(role));
    }

    @Test
    void update() {
        RoleDto roleDto = new RoleDto();
        Role role = ConverterDto.convertToModel(roleDto);
        roleService.update(roleDto);
        Mockito.verify(roleRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(role));
    }

    @Test
    void deleteById() {
        roleService.deleteById((long) 999);
        Mockito.verify(roleRepository, Mockito.times(1))
                .deleteById(ArgumentMatchers.eq((long) 999));
    }
}