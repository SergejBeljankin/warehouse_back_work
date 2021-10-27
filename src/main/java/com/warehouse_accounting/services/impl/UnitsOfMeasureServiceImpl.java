package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.UnitsOfMeasureDto;
import com.warehouse_accounting.repositories.UnitsOfMeasureRepository;
import com.warehouse_accounting.services.interfaces.UnitsOfMeasureService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UnitsOfMeasureServiceImpl implements UnitsOfMeasureService {

    private final UnitsOfMeasureRepository unitsOfMeasureRepository;

    public UnitsOfMeasureServiceImpl(UnitsOfMeasureRepository unitsOfMeasureRepository) {
        this.unitsOfMeasureRepository = unitsOfMeasureRepository;
    }


    @Override
    public List<UnitsOfMeasureDto> getAll() {
        return unitsOfMeasureRepository.getAll();
    }

    @Override
    public UnitsOfMeasureDto getById(Long id) {
        return unitsOfMeasureRepository.getById(id);
    }

    @Override
    public void create(UnitsOfMeasureDto dto) {
        unitsOfMeasureRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(UnitsOfMeasureDto dto) {
        unitsOfMeasureRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        unitsOfMeasureRepository.deleteById(id);
    }
}