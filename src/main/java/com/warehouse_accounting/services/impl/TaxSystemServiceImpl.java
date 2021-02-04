package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.TaxSystem;
import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.repositories.TaxSystemRepository;
import com.warehouse_accounting.services.interfaces.TaxSystemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TaxSystemServiceImpl implements TaxSystemService {

    private final TaxSystemRepository taxSystemRepository;

    public TaxSystemServiceImpl(TaxSystemRepository taxSystemRepository) {
        this.taxSystemRepository = taxSystemRepository;
    }

    @Override
    public List<TaxSystemDto> getAll() {
        return taxSystemRepository.getAll();
    }

    @Override
    public TaxSystemDto getById(Long id) {
        return taxSystemRepository.getById(id);
    }

    @Override
    public void create(TaxSystemDto taxSystemDto) {
        taxSystemRepository.save(
                TaxSystem.builder()
                        .name(taxSystemDto.getName())
                        .sortNumber(taxSystemDto.getSortNumber())
                        .build()
        );
    }

    @Override
    public void update(TaxSystemDto taxSystemDto) {
        taxSystemRepository.save(
                TaxSystem.builder()
                        .id(taxSystemDto.getId())
                        .name(taxSystemDto.getName())
                        .sortNumber(taxSystemDto.getSortNumber())
                        .build()
        );
    }

    @Override
    public void deleteById(Long id) {
        taxSystemRepository.deleteById(id);
    }
}
