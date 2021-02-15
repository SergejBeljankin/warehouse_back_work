package com.warehouse_accounting.config;

import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.repositories.RoleRepository;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;


@Component
public class DataInitializer {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @PostConstruct
    public void init() {
        initRole();
    }


    private void initRole() {
        Role admin = new Role(1L, "admin", "sort_admin");
        roleRepository.save(admin);
        Role user = new Role(2L, "user", "sort_user");
        roleRepository.save(user);
    }
}