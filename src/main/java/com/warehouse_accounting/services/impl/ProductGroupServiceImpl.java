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

    private final ProductGroupRepository repository;

    public ProductGroupServiceImpl(ProductGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductGroupDto> getAll() {
        List <ProductGroupDto> productGroupDtoList = repository.getAll();
        productGroupDtoList.forEach(productGroupDto -> {
            productGroupDto.setProductGroupDto(repository.getById(productGroupDto.getProductGroupDto().getId()));
        });
        return productGroupDtoList;
    }

    @Override
    public ProductGroupDto getById(Long id) {
        ProductGroupDto productGroupDto = repository.getById(id);
        productGroupDto.setProductGroupDto(repository.getById(productGroupDto.getProductGroupDto().getId()));
        return productGroupDto;
    }

    @Override
    public void create(ProductGroupDto productGroupDto) {
        repository.save(ConverterDto.convertToModel(productGroupDto));

    }

    @Override
    public void update(ProductGroupDto productGroupDto) {
        repository.save(ConverterDto.convertToModel(productGroupDto));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
