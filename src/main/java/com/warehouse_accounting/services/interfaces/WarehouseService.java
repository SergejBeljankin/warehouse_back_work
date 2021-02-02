package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.WarehouseDto;

import java.util.List;

public interface WarehouseService {
    WarehouseDto getById(Long id);

    void create(WarehouseDto warehouseDto);

    void update(WarehouseDto warehouseDto);

    void deleteById(Long id);

    List<WarehouseDto> findAll();
}
