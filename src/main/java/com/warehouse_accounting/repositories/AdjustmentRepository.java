package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Adjustment;
import com.warehouse_accounting.models.dto.AdjustmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdjustmentRepository extends JpaRepository<Adjustment, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.AdjustmentDto(" +
            "a.id, " +
            "a.number, " +
            "a.dateTimeAdjustment, " +
            "c.id, " +
            "c.name, " +
            "con.id, " +
            "con.name, " +
            "a.type, " +
            "a.currentBalance, " +
            "a.totalBalance, " +
            "a.adjustmentAmount, " +
            "a.comment, " +
            "a.whenСhanged " +
            ")" +
            "FROM Adjustment a " +
                "LEFT JOIN Company c ON (a.company.id = c.id) " +
                "LEFT JOIN Contractor con ON (a.contractor.id = con.id)")
    List<AdjustmentDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.AdjustmentDto(" +
            "a.id, " +
            "a.number, " +
            "a.dateTimeAdjustment, " +
            "c.id, " +
            "c.name, " +
            "con.id, " +
            "con.name, " +
            "a.type, " +
            "a.currentBalance, " +
            "a.totalBalance, " +
            "a.adjustmentAmount, " +
            "a.comment, " +
            "a.whenСhanged " +
            ")" +
            "FROM Adjustment a " +
            "LEFT JOIN Company c ON (a.company.id = c.id)" +
            "LEFT JOIN Contractor con ON (a.contractor.id = con.id)" +
            "WHERE a.id = :id")
    AdjustmentDto getById(@Param("id") Long id);
}

