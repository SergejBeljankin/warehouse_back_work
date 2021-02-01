package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Override
    List<Warehouse> findAll();
}
