package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.models.TechnologicalOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologicalOperationRepository extends JpaRepository<TechnologicalOperation, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalOperationDto(" +
            "t.id, " +
            "t.number, " +
            "t.isArchive, " +
            "t.date, " +
            "t.volumeOfProduction, " +
            "t.comments, " +
            "wm.id, " +
            "wm.name, " +
            "wp.id, " +
            "wp.name, " +
            "c.id, " +
            "c.name, " +
            "p.id, " +
            "p.name, " +
            "tech.id, " +
            "tech.name)" +
            "FROM TechnologicalOperation t " +
            "LEFT JOIN Warehouse wm ON (t.warehouseForMaterials.id = wm.id) " +
            "LEFT JOIN Warehouse wp ON (t.warehouseForProduct.id = wp.id) " +
            "LEFT JOIN Company c ON (t.company.id = c.id) " +
            "LEFT JOIN Project p ON (t.project.id = p.id) " +
            "LEFT JOIN TechnologicalMap tech ON (t.technologicalMap.id = tech.id) ")
    List<TechnologicalOperationDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalOperationDto("+
            "t.id, " +
            "t.number, " +
            "t.isArchive, " +
            "t.date, " +
            "t.volumeOfProduction, " +
            "t.comments, " +
            "wm.id, " +
            "wm.name, " +
            "wp.id, " +
            "wp.name, " +
            "c.id, " +
            "c.name, " +
            "p.id, " +
            "p.name, " +
            "tech.id, " +
            "tech.name )" +
            "FROM TechnologicalOperation t " +
            "LEFT JOIN Warehouse wm ON (t.warehouseForMaterials.id = wm.id) " +
            "LEFT JOIN Warehouse wp ON (t.warehouseForProduct.id = wp.id) " +
            "LEFT JOIN Company c ON (t.company.id = c.id) " +
            "LEFT JOIN Project p ON (t.project.id = p.id) " +
            "LEFT JOIN TechnologicalMap tech ON (t.technologicalMap.id = tech.id)" +
            "WHERE t.id = :id")
    TechnologicalOperationDto getById(@Param("id") Long id);
}
