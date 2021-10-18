package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Requisites;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.models.dto.RequisitesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisitesRepository extends JpaRepository<Requisites, Long> {
    @Query("SELECT new com.warehouse_accounting.models.dto.RequisitesDto(" +
            "r.id," +
            "r.organization," +
            "r.legalAddress,"+
            "r.INN,"+
            "r.KPP,"+
            "r.BIK,"+
            "r.checkingAccount"+
            ")"+
            "FROM Requisites r")
    List<RequisitesDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.RequisitesDto(" +
            "r.id," +
            "r.organization," +
            "r.legalAddress,"+
            "r.INN,"+
            "r.KPP,"+
            "r.BIK,"+
            "r.checkingAccount"+
            ")"+
            "FROM Requisites r WHERE r.id=:id")
    RequisitesDto getById(@Param("id") Long id);

}
