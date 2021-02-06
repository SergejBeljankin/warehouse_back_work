package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.Warehouse;
import com.warehouse_accounting.models.dto.WarehouseDto;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.WarehouseService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public WarehouseDto getById(Long id) {
        return warehouseRepository.getById(id);
    }

    @Override
    public void create(WarehouseDto warehouseDto) {
        warehouseRepository.save(ConverterDto.convertToModel(warehouseDto));
    }

    @Override
    public void update(WarehouseDto warehouseDto) {
        Optional<Warehouse> updateWarehouse = warehouseRepository.findById(warehouseDto.getId());
        if (updateWarehouse.isPresent()) {
            Warehouse warehouse = updateWarehouse.get();
            warehouse.setName(warehouseDto.getName());
            warehouse.setSortNumber(warehouseDto.getSortNumber());
            warehouse.setAddress(warehouseDto.getAddress());
            warehouse.setCommentToAddress(warehouseDto.getCommentToAddress());
            warehouse.setComment(warehouseDto.getComment());
            warehouseRepository.save(warehouse);
        }
    }

    @Override
    public void deleteById(Long id) {
        warehouseRepository.deleteById(id);
    }

    @Override
    public List<WarehouseDto> getAll() {
        return warehouseRepository.getAll();
    }


}
