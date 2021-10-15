package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.ShipmentDto;

import java.util.List;

public interface ShipmentService {
    List<ShipmentDto> getAll();

    ShipmentDto getById(Long id);

    void create(ShipmentDto shipmentDto);

    void update(ShipmentDto shipmentDto);

    void deleteById(Long id);
}
