package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.repositories.TypeOfContractorRepository;
import com.warehouse_accounting.services.interfaces.LegalDetailService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LegalDetailServiceImpl implements LegalDetailService {

    private final LegalDetailRepository legalDetailRepository;
    private final TypeOfContractorRepository typeOfContractorRepository;

    public LegalDetailServiceImpl(LegalDetailRepository legalDetailRepository, TypeOfContractorRepository typeOfContractorRepository) {
        this.legalDetailRepository = legalDetailRepository;
        this.typeOfContractorRepository = typeOfContractorRepository;
    }

    @Override
    public List<LegalDetailDto> getAll()
    {
        List<LegalDetailDto> legalDetailDtos = legalDetailRepository.getAll();
        for (LegalDetailDto legalDetailDto: legalDetailDtos) {
            legalDetailDto.setTypeOfContractorDto(typeOfContractorRepository.getById(legalDetailDto.getTypeOfContractorDto().getId()));
        }
        return legalDetailDtos;
    }

    @Override
    public LegalDetailDto getById(Long id) {
        LegalDetailDto legalDetailDto = legalDetailRepository.getById(id);
        legalDetailDto.setTypeOfContractorDto(typeOfContractorRepository.getById(legalDetailDto.getTypeOfContractorDto().getId()));
        return legalDetailDto;
    }

    @Override
    public void create(LegalDetailDto legalDetailDto) {
        legalDetailRepository.save(ConverterDto.convertToModel(legalDetailDto));
    }

    @Override
    public void update(LegalDetailDto legalDetailDto) {
        legalDetailRepository.save(ConverterDto.convertToModel(legalDetailDto));
    }

    @Override
    public void deleteById(Long id) {
        legalDetailRepository.deleteById(id);
    }
}
