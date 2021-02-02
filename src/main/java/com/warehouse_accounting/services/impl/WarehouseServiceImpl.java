package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.Warehouse;
import com.warehouse_accounting.models.dto.WarehouseDto;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.WarehouseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {
    private WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public WarehouseDto getById(Long id) {
        Optional<Warehouse> warehouseById = warehouseRepository.findById(id);
        if (warehouseById.isPresent()) {
            Warehouse warehouse = warehouseById.get();
            return toWarehouseDto(warehouse);
        } else {
            throw new EntityNotFoundException(String.format("Entity warehouse by id '%d' not found", id));
        }
    }

    @Override
    public void create(WarehouseDto warehouseDto) {
        warehouseRepository.save(toWarehouse(warehouseDto));
    }

    @Override
    public void update(WarehouseDto warehouseDto) {
        Optional<Warehouse> warehouseById = warehouseRepository.findById(warehouseDto.getId());
        if (warehouseById.isPresent()) {
            Warehouse warehouse = warehouseById.get();
            warehouse.setName(warehouseDto.getName());
            warehouse.setSortNumber(warehouseDto.getSortNumber());
            warehouse.setAddress(warehouseDto.getAddress());
            warehouse.setCommentToAddress(warehouseDto.getCommentToAddress());
            warehouse.setComment(warehouseDto.getComment());
            warehouseRepository.save(warehouse);
        } else {
            throw new EntityNotFoundException(String.format("Entity warehouse by id '%d' not found", warehouseDto.getId()));
        }
    }

    @Override
    public void deleteById(Long id) {
        warehouseRepository.deleteById(id);
    }

    @Override
    public List<WarehouseDto> findAll() {
        return warehouseRepository.findAll().stream()
                .map(this::toWarehouseDto)
                .collect(Collectors.toList());
    }

    private WarehouseDto toWarehouseDto(Warehouse warehouse) {
        return WarehouseDto.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .sortNumber(warehouse.getSortNumber())
                .address(warehouse.getAddress())
                .commentToAddress(warehouse.getCommentToAddress())
                .comment(warehouse.getComment())
                .build();
    }

    private Warehouse toWarehouse(WarehouseDto warehouseDto) {
        return Warehouse.builder()
                .id(warehouseDto.getId())
                .name(warehouseDto.getName())
                .sortNumber(warehouseDto.getSortNumber())
                .address(warehouseDto.getAddress())
                .commentToAddress(warehouseDto.getCommentToAddress())
                .comment(warehouseDto.getComment())
                .build();
    }
}
