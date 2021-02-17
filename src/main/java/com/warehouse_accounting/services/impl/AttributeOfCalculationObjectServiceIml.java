package com.warehouse_accounting.services.impl;

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

    private final AttributeOfCalculationObjectRepository attributeOfCalculationObjectRepository;

    public AttributeOfCalculationObjectServiceIml(AttributeOfCalculationObjectRepository repository) {
        this.attributeOfCalculationObjectRepository = repository;
    }

    @Override
    public List<AttributeOfCalculationObjectDto> getAll() {
        return attributeOfCalculationObjectRepository.getAll();
    }

    @Override
    public AttributeOfCalculationObjectDto getById(Long id) {
        return attributeOfCalculationObjectRepository.getById(id);
    }

    @Override
    public void create(AttributeOfCalculationObjectDto dto) {
        attributeOfCalculationObjectRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(AttributeOfCalculationObjectDto dto) {
        attributeOfCalculationObjectRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        attributeOfCalculationObjectRepository.deleteById(id);
    }
}
