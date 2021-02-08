package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.services.interfaces.CompanyService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyDto> getAll() {
        List<CompanyDto> companyDtos = companyRepository.getAll();
        for(CompanyDto companyDto: companyDtos) {
            companyDto.setLegalDetailDto(ConverterDto.convertToDto(companyRepository.getByCompanyId(companyDto.getId())));
        }
        return companyDtos;
    }

    @Override
    public CompanyDto getById(Long id) {
        CompanyDto companyDto = companyRepository.getById(id);
        companyDto.setLegalDetailDto(ConverterDto.convertToDto(companyRepository.getByCompanyId(companyDto.getId())));
        return companyDto;
    }

    @Override
    public void create(CompanyDto dto) {
        companyRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(CompanyDto dto) {
        companyRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
