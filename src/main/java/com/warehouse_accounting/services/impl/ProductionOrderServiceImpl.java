package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ProductionOrderDto;
import com.warehouse_accounting.repositories.ProductionOrderRepository;

import com.warehouse_accounting.services.interfaces.ProductionOrderService;
import com.warehouse_accounting.util.ConverterDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ProductionOrderServiceImpl implements ProductionOrderService {

    private final ProductionOrderRepository productionOrderRepository;

    public ProductionOrderServiceImpl(ProductionOrderRepository productionOrderRepository) {
        this.productionOrderRepository = productionOrderRepository;
    }


    @Override
    public List<ProductionOrderDto> getAll() {
        List<ProductionOrderDto> productionOrderDtoList = productionOrderRepository.getAll();
        return productionOrderDtoList;
    }

    @Override
    public ProductionOrderDto getById(Long id) {
        ProductionOrderDto productionOrderDto = productionOrderRepository.getById(id);
        return productionOrderDto;
    }

    @Override
    public void create(ProductionOrderDto productionOrderDto) {
        productionOrderRepository.save(ConverterDto.convertToModel(productionOrderDto));
    }

    @Override
    public void update(ProductionOrderDto productionOrderDto) {
        productionOrderRepository.save(ConverterDto.convertToModel(productionOrderDto));
    }

    @Override
    public void delete(Long id) {
        productionOrderRepository.deleteById(id);
    }
}
