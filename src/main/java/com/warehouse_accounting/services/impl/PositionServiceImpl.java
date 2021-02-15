package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.PositionDto;
import com.warehouse_accounting.repositories.PositionRepository;
import com.warehouse_accounting.services.interfaces.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.warehouse_accounting.util.ConverterDto.convertToModel;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<PositionDto> getAll() {
        return positionRepository.getAll();
    }

    @Override
    public PositionDto getById(Long id) {
        return positionRepository.getById(id);
    }

    @Override
    public void create(PositionDto positionDto) {
        positionRepository.save(convertToModel(positionDto));
    }

    @Override
    public void update(PositionDto positionDto) {
        positionRepository.save(convertToModel(positionDto));
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }
}
