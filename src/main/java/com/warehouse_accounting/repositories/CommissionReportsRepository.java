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
            "con.id, " +
            "contr.id," +
            "org.id," +
            "p.id," +
            "cr.sum," +
            "cr.paid," +
            "cr.isSent," +
            "cr.isPrinted," +
            "cr.comment," +
            "cr.periodStart," +
            "cr.periodEnd," +
            "cr.reward) " +
            "FROM CommissionReports cr " +
            "LEFT JOIN Contract con ON (cr.contract.id = con.id)" +
            "LEFT JOIN Contractor contr ON (cr.contractor.id = contr.id)" +
            "LEFT JOIN Company org ON (cr.company.id = org.id)" +
            "LEFT JOIN Project p ON (cr.project.id = p.id)")
    List<CommissionReportsDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CommissionReportsDto(" +
            "cr.id, " +
            "cr.dateOfCreation," +
            "con.id, " +
            "contr.id," +
            "org.id," +
            "p.id," +
            "cr.sum," +
            "cr.paid," +
            "cr.isSent," +
            "cr.isPrinted," +
            "cr.comment," +
            "cr.periodStart," +
            "cr.periodEnd," +
            "cr.reward) " +
            "FROM CommissionReports cr " +
            "LEFT JOIN Contract con ON (cr.contract.id = con.id)" +
            "LEFT JOIN Contractor contr ON (cr.contractor.id = contr.id)" +
            "LEFT JOIN Company org ON (cr.company.id = org.id)" +
            "LEFT JOIN Project p ON (cr.project.id = p.id)" +
            "WHERE cr.id = :id")
    CommissionReportsDto getById(@Param("id") Long id);
}
