package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.TaxSystem;
import com.warehouse_accounting.models.dto.TaxSystemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaxSystemRepository extends JpaRepository<TaxSystem, Long> {

    @Query("SELECT new com.warehouse_accounting.models.dto.TaxSystemDto(" +
            "ts.id, " +
            "ts.name, " +
            "ts.sortNumber" +
            ") " +
            "FROM TaxSystem ts")
    public List<TaxSystemDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.TaxSystemDto(" +
            "ts.id, " +
            "ts.name, " +
            "ts.sortNumber" +
            ") " +
            "FROM TaxSystem ts where ts.id = :id")
    public TaxSystemDto getById(@Param("id") Long id);
}
