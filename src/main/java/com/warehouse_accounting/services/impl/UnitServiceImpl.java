package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.repositories.UnitRepository;
import com.warehouse_accounting.services.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

    private UnitRepository unitRepository;

    @Autowired
    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public List<UnitDto> getAll() {
        return unitRepository.getAll();
    }

    @Override
    public UnitDto getById(Long id) {
        return unitRepository.getById(id);
    }

    @Override
    public void create(UnitDto unitDto) {
        unitRepository.create(unitDto);
    }

    @Override
    public void update(UnitDto unitDto) {
        unitRepository.update(unitDto);
    }

    @Override
    public void deleteById(Long id) {
        unitRepository.deleteById(id);
    }

}
