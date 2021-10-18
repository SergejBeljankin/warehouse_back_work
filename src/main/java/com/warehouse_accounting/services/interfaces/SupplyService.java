package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.SupplyDto;

import java.util.List;

public interface SupplyService {
    List<SupplyDto> getAll();

    SupplyDto getById(Long id);

    void create(SupplyDto supplyDto);

    void update(SupplyDto supplyDto);

    void deleteById(Long id);
}
