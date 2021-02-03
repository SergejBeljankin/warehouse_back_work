package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Warehouse;
import com.warehouse_accounting.models.dto.WarehouseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query("SELECT new com.warehouse_accounting.models.dto.WarehouseDto(w.id" +
            ",w.name" +
            ",w.address" +
            ",w.commentToAddress" +
            ",w.comment)" +
            "FROM Warehouse w ")
    List<WarehouseDto> findAllWarehouseDto();

    @Query("SELECT new com.warehouse_accounting.models.dto.WarehouseDto(w.id" +
            ",w.name" +
            ",w.address" +
            ",w.commentToAddress" +
            ",w.comment)" +
            "FROM Warehouse w " +
            "WHERE w.id = :id")
    WarehouseDto getWarehouseDtoById(@Param("id") Long id);
}
