package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.services.impl.RoleServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.mockito.Mockito.when;


@SpringBootTest
class RoleServiceTest {

    private static RoleDto roleDto1;
    private static RoleDto roleDto2;
    private static List<RoleDto> roleDtoList;

    @InjectMocks
    private RoleServiceImpl roleService;

    @Mock
    private RoleRepository roleRepository;

    @BeforeAll
    static void initMethod() {
        roleDto1 = RoleDto.builder()
                .id((long)1)
                .sortNumber("1")
                .name("first")
                .build();
        roleDto2 = RoleDto.builder()
                .id((long)2)
                .sortNumber("2")
                .name("second")
                .build();
        roleDtoList = List.of(roleDto1, roleDto2);
    }

    @Test
    void getAll() {
        when(roleRepository.getAll()).thenReturn(roleDtoList);
        List<RoleDto> resultRoleDtoList = roleService.getAll();
        Assertions.assertEquals(resultRoleDtoList, roleDtoList);
        Assert.notNull(resultRoleDtoList, "а тут вылез null");
        Mockito.verify(roleRepository, Mockito.times(1))
                .getAll();
    }

    @Test
    void getById() {
        when(roleRepository.getById((long)1)).thenReturn(roleDto1);
        Assertions.assertEquals(roleService.getById((long) 1), roleDto1);
        Mockito.verify(roleRepository, Mockito.times(1))
                .getById(ArgumentMatchers.eq((long) 1));

    }

    @Test
    void create() {
        Role role = ConverterDto.convertToModel(roleDto1);
        roleService.create(roleDto1);
        Mockito.verify(roleRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(role));
    }

    @Test
    void update() {
        Role role = ConverterDto.convertToModel(roleDto2);
        roleService.update(roleDto2);
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