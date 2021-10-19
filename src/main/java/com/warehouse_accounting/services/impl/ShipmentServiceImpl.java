package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ShipmentDto;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.repositories.ShipmentRepository;
import com.warehouse_accounting.services.interfaces.ShipmentService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, ProductRepository productRepository) {
        this.shipmentRepository = shipmentRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ShipmentDto> getAll() {
        List<ShipmentDto> shipmentDtos = shipmentRepository.getAll();
        for (ShipmentDto dto : shipmentDtos) {
            dto.setProductDtos(productRepository
                    .getListProductById(dto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
        }
        return shipmentDtos;
    }

    @Override
    public ShipmentDto getById(Long id) {
        ShipmentDto shipmentDto = shipmentRepository.getById(id);

        shipmentDto.setProductDtos(productRepository
                .getListProductById(shipmentDto.getId())
                .stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList()));

        return shipmentDto;
    }

    @Override
    public void create(ShipmentDto shipmentDto) {
        shipmentRepository.save(ConverterDto.convertToModel(shipmentDto));
    }

    @Override
    public void update(ShipmentDto shipmentDto) {
        shipmentRepository.save(ConverterDto.convertToModel(shipmentDto));
    }

    @Override
    public void deleteById(Long id) {
        shipmentRepository.deleteById(id);
    }
}
