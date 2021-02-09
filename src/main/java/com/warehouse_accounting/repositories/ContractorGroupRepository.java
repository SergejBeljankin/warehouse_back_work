package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.ContractorGroup;
import com.warehouse_accounting.models.dto.ContractorGroupDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractorGroupRepository extends JpaRepository<ContractorGroup, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ContractorGroupDto(" +
            "cg.id," +
            "cg.name," +
            "cg.sortNumber)" +
            "FROM ContractorGroup cg")
    List<ContractorGroupDto> getAll();


    @Query("SELECT NEW com.warehouse_accounting.models.dto.ContractorGroupDto(" +
            "cg.id," +
            "cg.name," +
            "cg.sortNumber)" +
            "FROM ContractorGroup cg WHERE cg.id = :id")
    ContractorGroupDto getById(@Param("id") Long id);
}
