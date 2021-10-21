package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.RecycleBinDto;
import com.warehouse_accounting.repositories.RecycleBinRepository;
import com.warehouse_accounting.services.interfaces.RecycleBinService;
import com.warehouse_accounting.util.ConverterDto;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecycleBinServiceImpl implements RecycleBinService {

    private final RecycleBinRepository recycleBinRepository;

    public RecycleBinServiceImpl(RecycleBinRepository recycleBinRepository) {
        this.recycleBinRepository = recycleBinRepository;
    }

    @Override
    public List<RecycleBinDto> getAll() {
        return recycleBinRepository.getAll();
    }

    @Override
    public RecycleBinDto getById(Long id) {
        return recycleBinRepository.getById(id);
    }

    @Override
    public void create(RecycleBinDto recycleBinDto) {
        recycleBinRepository.save(ConverterDto.convertToModel(recycleBinDto));
    }

    @Override
    public void update(RecycleBinDto recycleBinDto) {
        recycleBinRepository.save(ConverterDto.convertToModel(recycleBinDto));
    }

    @Override
    public void deleteById(Long id) {
        recycleBinRepository.deleteById(id);
    }
}
