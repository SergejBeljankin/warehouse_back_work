package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.CommissionReports;
import com.warehouse_accounting.models.dto.CommissionReportsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommissionReportsRepository extends JpaRepository<CommissionReports, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CommissionReportsDto(" +
            "cr.id, " +
            "cr.dateOfCreation," +
            "cr.contract.id, " +
            "cr.contractor.id," +
            "cr.company.id," +
            "cr.project.id," +
            "cr.sum," +
            "cr.paid," +
            "cr.isSent," +
            "cr.isPrinted," +
            "cr.comment," +
            "cr.periodStart," +
            "cr.periodEnd," +
            "cr.reward) " +
            "FROM CommissionReports cr ")
    List<CommissionReportsDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CommissionReportsDto(" +
            "cr.id, " +
            "cr.dateOfCreation," +
            "cr.contract.id, " +
            "cr.contractor.id," +
            "cr.company.id," +
            "cr.project.id," +
            "cr.sum," +
            "cr.paid," +
            "cr.isSent," +
            "cr.isPrinted," +
            "cr.comment," +
            "cr.periodStart," +
            "cr.periodEnd," +
            "cr.reward) " +
            "FROM CommissionReports cr "+
            "WHERE cr.id = :id")
    CommissionReportsDto getById(@Param("id") Long id);
}
