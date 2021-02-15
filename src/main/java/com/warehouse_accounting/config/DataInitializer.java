package com.warehouse_accounting.config;

import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.services.interfaces.RoleService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;


@Component
public class DataInitializer {

    private final RoleService roleService;

    public DataInitializer(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        initRoles();
    }

    private void initRoles() {
        roleService.create(RoleDto.builder()
                .name("Admin")
                .sortNumber("sortAdmin")
                .build());
        roleService.create(RoleDto.builder()
                .name("User")
                .sortNumber("sortUser")
                .build());
    }
}