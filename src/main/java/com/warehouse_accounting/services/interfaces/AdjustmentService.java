package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.AdjustmentDto;

import java.util.List;

public interface AdjustmentService {

    List<AdjustmentDto> getAll();

    AdjustmentDto getById(Long id);

    void create(AdjustmentDto adjustmentDto);

    void update(AdjustmentDto adjustmentDto);

    void deleteById(Long id);
}
