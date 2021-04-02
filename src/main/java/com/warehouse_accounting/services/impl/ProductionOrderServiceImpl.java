package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.ProductionOrder;
import com.warehouse_accounting.models.dto.InvoiceEditDto;
import com.warehouse_accounting.models.dto.ProductionOrderDto;
import com.warehouse_accounting.repositories.ProductionOrderRepository;
import com.warehouse_accounting.repositories.TechnologicalMapRepository;
import com.warehouse_accounting.services.interfaces.ProductionOrderService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductionOrderServiceImpl implements ProductionOrderService {

    private final ProductionOrderRepository productionOrderRepository;
    private final TechnologicalMapRepository technologicalMapRepository;

    public ProductionOrderServiceImpl(ProductionOrderRepository productionOrderRepository,
                                      TechnologicalMapRepository technologicalMapRepository) {
        this.productionOrderRepository = productionOrderRepository;
        this.technologicalMapRepository = technologicalMapRepository;
    }


    @Override
    public List<ProductionOrderDto> getAll() {
        List<ProductionOrderDto> productionOrderDtoList = productionOrderRepository.getAll();
        for (ProductionOrderDto order : productionOrderDtoList) {
            order.setTechMapDto(technologicalMapRepository.getById(order.getTechMapDto().getId()));
        }
        return productionOrderDtoList;

    }

    @Override
    public ProductionOrderDto getById(Long id) {
        ProductionOrderDto productionOrderDto = productionOrderRepository.getById(id);
        productionOrderDto.setTechMapDto(technologicalMapRepository.getById(productionOrderDto.getTechMapDto().getId()));
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
