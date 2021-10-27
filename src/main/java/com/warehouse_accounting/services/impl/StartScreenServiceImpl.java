package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.StartScreenDto;
import com.warehouse_accounting.repositories.StartScreenRepository;
import com.warehouse_accounting.services.interfaces.StartScreenService;
import com.warehouse_accounting.util.ConverterDto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StartScreenServiceImpl implements StartScreenService {
    private final StartScreenRepository startScreenRepository;

    public StartScreenServiceImpl(StartScreenRepository startScreenRepository) {
        this.startScreenRepository = startScreenRepository;
    }

    @Override
    public List<StartScreenDto> getAll() {
        return startScreenRepository.getAll();
    }

    @Override
    public StartScreenDto getById(Long id) {
        return startScreenRepository.getById(id);
    }

    @Override
    public void create(StartScreenDto startScreenDto) {
        startScreenRepository.save(ConverterDto.convertToModel(startScreenDto));

    }

    @Override
    public void update(StartScreenDto startScreenDto) {
        startScreenRepository.save(ConverterDto.convertToModel(startScreenDto));
    }

    @Override
    public void deleteById(Long id) {
        startScreenRepository.deleteById(id);

    }
}
