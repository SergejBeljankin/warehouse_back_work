package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.AttributeOfCalculationObject;
import com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto;
import com.warehouse_accounting.repositories.AttributeOfCalculationObjectRepository;
import com.warehouse_accounting.services.interfaces.AttributeOfCalculationObjectService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AttributeOfCalculationObjectServiceIml implements AttributeOfCalculationObjectService {

    private final AttributeOfCalculationObjectRepository repository;

    public AttributeOfCalculationObjectServiceIml(AttributeOfCalculationObjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AttributeOfCalculationObjectDto> getAll() {
        return repository.getAll();
    }

    @Override
    public AttributeOfCalculationObjectDto getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void create(AttributeOfCalculationObjectDto dto) {
        repository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(AttributeOfCalculationObjectDto dto) {
        repository.saveAndFlush(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
