package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.dto.RoleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends
        JpaRepository<Role, Long> {
    String ROLE_DTO_CONSTRUCTOR = "com.warehouse_accounting.models.dto.RoleDto(" +
            "r.id," +
            "r.name," +
            "r.sortNumber,";

    @Query("SELECT NEW " + ROLE_DTO_CONSTRUCTOR + "FROM Role r")
    List<RoleDto> getAll();

    @Query("SELECT NEW " + ROLE_DTO_CONSTRUCTOR + "FROM Role r WHERE r.id=:id")
    RoleDto getById(@Param("id") Long id);

}
