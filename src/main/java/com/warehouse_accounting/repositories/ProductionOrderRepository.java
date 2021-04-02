package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.ProductionOrder;
import com.warehouse_accounting.models.dto.ProductionOrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductionOrderDto(" +
            "po.id, " +
            "po.number, " +
            "po.dateTime, " +
            "c.id, " +
            "c.name, " +
            "po.technologicalMap.id, " +
            "po.volumeOfProduction, " +
            "w.id, " +
            "w.name, " +
            "po.planDate, " +
            "p.id, " +
            "p.name, " +
            "po.comment)" +
            "FROM ProductionOrder po " +
            "LEFT JOIN Company c ON (po.company.id = c.id)" +
            "LEFT JOIN Project p ON (po.project.id = p.id)" +
            "LEFT JOIN Warehouse w ON (po.warehouseForMaterials.id = w.id)")
    List<ProductionOrderDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductionOrderDto(" +
            "po.id, " +
            "po.number, " +
            "po.dateTime, " +
            "c.id, " +
            "c.name, " +
            "po.technologicalMap.id, " +
            "po.volumeOfProduction, " +
            "w.id, " +
            "w.name, " +
            "po.planDate, " +
            "p.id, " +
            "p.name, " +
            "po.comment)" +
            "FROM ProductionOrder po " +
            "LEFT JOIN Company c ON (po.company.id = c.id)" +
            "LEFT JOIN Project p ON (po.project.id = p.id)" +
            "LEFT JOIN Warehouse w ON (po.warehouseForMaterials.id = w.id)"+
            "WHERE po.id = :id")
    ProductionOrderDto getById(@Param("id") Long id);
}
