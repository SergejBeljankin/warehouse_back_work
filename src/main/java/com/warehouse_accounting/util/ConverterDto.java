package com.warehouse_accounting.util;

import com.warehouse_accounting.models.Department;
import com.warehouse_accounting.models.DepartmentDto;
import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.dto.RoleDto;


public class ConverterDto {

    private ConverterDto() {
    }

    public static RoleDto convertToDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .sortNumber(role.getSortNumber())
                .build();
    }

    public static Role convertToModel(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .sortNumber(roleDto.getSortNumber())
                .build();
    }

    public static Department convertToModel (DepartmentDto departmentDto){
        return Department.builder()
                .id(departmentDto.getId())
                .name(departmentDto.getName())
                .sortNumber(departmentDto.getSortNumber())
                .build();
    }
    public static DepartmentDto convertToDto(Department department){
        return DepartmentDto.builder()
                .id(department.getId())
                .name(department.getName())
                .sortNumber(department.getSortNumber())
                .build();
    }
}
