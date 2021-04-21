package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.AdjustmentDto;
import com.warehouse_accounting.repositories.AdjustmentRepository;
import com.warehouse_accounting.services.interfaces.AdjustmentService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdjustmentServiceImpl implements AdjustmentService {

    private final AdjustmentRepository adjustmentRepository;

    public AdjustmentServiceImpl(AdjustmentRepository repository) {
        this.adjustmentRepository = repository;
    }

    @Override
    public List<AdjustmentDto> getAll() {
        return adjustmentRepository.getAll();
    }

    @Override
    public AdjustmentDto getById(Long id) {
        return adjustmentRepository.getById(id);
    }

    @Override
    public void create(AdjustmentDto dto) {
        adjustmentRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(AdjustmentDto dto) {
        adjustmentRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        adjustmentRepository.deleteById(id);
    }
}
