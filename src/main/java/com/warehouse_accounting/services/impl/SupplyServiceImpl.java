package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.SupplyDto;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.repositories.SupplyRepository;
import com.warehouse_accounting.services.interfaces.SupplyService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository, ProductRepository productRepository) {
        this.supplyRepository = supplyRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<SupplyDto> getAll() {
        List<SupplyDto> supplyDtos = supplyRepository.getAll();
        for(SupplyDto dto : supplyDtos){
            dto.setProductDtos(productRepository
                    .getListProductById(dto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
        }

        return supplyDtos;
    }

    @Override
    public SupplyDto getById(Long id) {
        SupplyDto supplyDto = supplyRepository.getById(id);

        supplyDto.setProductDtos(productRepository
                    .getListProductById(supplyDto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));

        return supplyDto;
    }

    @Override
    public void create(SupplyDto supplyDto) {
        supplyRepository.save(ConverterDto.convertToModel(supplyDto));
    }

    @Override
    public void update(SupplyDto supplyDto) {
        supplyRepository.save(ConverterDto.convertToModel(supplyDto));
    }

    @Override
    public void deleteById(Long id) {
        supplyRepository.deleteById(id);
    }
}
