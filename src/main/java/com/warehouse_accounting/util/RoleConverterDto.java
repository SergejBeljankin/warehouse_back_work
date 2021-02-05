package com.warehouse_accounting.util;

import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.dto.RoleDto;


public class RoleConverterDto {

    private RoleConverterDto() {
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
}
