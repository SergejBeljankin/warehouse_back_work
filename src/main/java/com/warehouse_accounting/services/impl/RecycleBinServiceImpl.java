package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.RecycleBinDto;
import com.warehouse_accounting.repositories.RecycleBinRepository;
import com.warehouse_accounting.services.interfaces.RecycleBinService;
import com.warehouse_accounting.util.ConverterDto;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class RecycleBinServiceImpl implements RecycleBinService {
    @Delegate
    RecycleBinRepository recycleBinRepository;

    @Override
    public List<RecycleBinDto> getAll() {
        return recycleBinRepository.findAll().stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecycleBinDto getById(Long id) {
        return recycleBinRepository.findById(id)
                .map(ConverterDto::convertToDto)
                .orElseThrow();
    }

    @Override
    public void create(RecycleBinDto recycleBinDto) {
        recycleBinRepository.save(ConverterDto.convertToModel(recycleBinDto));
    }

    @Override
    public void update(RecycleBinDto recycleBinDto) {
        var recycleBin = ConverterDto.convertToModel(recycleBinDto);
        recycleBin.setId(recycleBinDto.getId());
        recycleBinRepository.save(recycleBin);
    }
}
