package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ApplicationDto;
import com.warehouse_accounting.repositories.ApplicationRepository;
import com.warehouse_accounting.services.interfaces.ApplicationService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }


    @Override
    public List<ApplicationDto> getAll() {
        return applicationRepository.getAll();
    }

    @Override
    public ApplicationDto getById(Long id) {
        return applicationRepository.getById(id);
    }

    @Override
    public void create(ApplicationDto dto) {
        applicationRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(ApplicationDto dto) {
        applicationRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        applicationRepository.deleteById(id);
    }
}
