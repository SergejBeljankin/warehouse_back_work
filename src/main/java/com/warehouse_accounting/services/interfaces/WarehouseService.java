package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.WarehouseDto;

public interface WarehouseService {
    WarehouseDto getById(Long id);

    void create(WarehouseDto warehouseDto);

    void update(WarehouseDto warehouseDto);

    void deleteById(Long id);
}
