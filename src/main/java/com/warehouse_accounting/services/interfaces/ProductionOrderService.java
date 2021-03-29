package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.ProductionOrderDto;

import java.util.List;

public interface ProductionOrderService {

    List<ProductionOrderDto> getAll();

    ProductionOrderDto getById();

    void create(ProductionOrderDto productionOrderDto);

    void update(ProductionOrderDto productionOrderDto);

    void delete(Long id);
}
