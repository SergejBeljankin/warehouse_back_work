package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.repositories.TypeOfContractorRepository;
import com.warehouse_accounting.services.interfaces.LegalDetailService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class LegalDetailServiceImpl implements LegalDetailService {

    private final LegalDetailRepository legalDetailRepository;


    public LegalDetailServiceImpl(LegalDetailRepository legalDetailRepository) {
        this.legalDetailRepository = legalDetailRepository;
    }

    @Override
    public List<LegalDetailDto> getAll() {
        return legalDetailRepository.getAll();
    }

    @Override
    public LegalDetailDto getById(Long id) {
        return legalDetailRepository.getById(id);
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

    @Override
    public List<LegalDetailDto> getAllBySpecification(Specification<LegalDetail> specifications) {
        return legalDetailRepository.findAll(specifications)
                .stream()
                .map(ConverterDto::convertToDto).collect(Collectors.toList());
    }
}
