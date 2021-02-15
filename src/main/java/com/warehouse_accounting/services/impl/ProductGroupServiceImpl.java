package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ProductGroupDto;
import com.warehouse_accounting.repositories.ProductGroupRepository;
import com.warehouse_accounting.services.interfaces.ProductGroupService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductGroupServiceImpl implements ProductGroupService {

    private final ProductGroupRepository productGroupRepository;

    public ProductGroupServiceImpl(ProductGroupRepository repository) {
        this.productGroupRepository = repository;
    }

    @Override
    public List<ProductGroupDto> getAll() {
        List <ProductGroupDto> productGroupDtoList = productGroupRepository.getAll();
        productGroupDtoList.forEach(productGroupDto -> {
            productGroupDto.setProductGroupDto(productGroupRepository.getById(productGroupDto.getProductGroupDto().getId()));
        });
        return productGroupDtoList;
    }

    @Override
    public ProductGroupDto getById(Long id) {
        ProductGroupDto productGroupDto = productGroupRepository.getById(id);
        productGroupDto.setProductGroupDto(productGroupRepository.getById(productGroupDto.getProductGroupDto().getId()));
        return productGroupDto;
    }

    @Override
    public void create(ProductGroupDto productGroupDto) {
        productGroupRepository.save(ConverterDto.convertToModel(productGroupDto));

    }

    @Override
    public void update(ProductGroupDto productGroupDto) {
        productGroupRepository.save(ConverterDto.convertToModel(productGroupDto));
    }

    @Override
    public void deleteById(Long id) {
        productGroupRepository.deleteById(id);
    }
}
