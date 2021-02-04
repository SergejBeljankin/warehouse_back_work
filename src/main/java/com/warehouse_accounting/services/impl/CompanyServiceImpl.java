package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.services.interfaces.CompanyService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository compRepository;

    public CompanyServiceImpl(CompanyRepository compRep) {
        this.compRepository = compRep;
    }

    @Override
    public List<CompanyDto> getAll() {
        return compRepository.getAll();
    }

    @Override
    public CompanyDto getById(Long id) {
        return compRepository.getById(id);
    }

    @Override
    public void create(CompanyDto dto) {
        compRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(CompanyDto dto) {
        compRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        compRepository.deleteById(id);
    }
}
