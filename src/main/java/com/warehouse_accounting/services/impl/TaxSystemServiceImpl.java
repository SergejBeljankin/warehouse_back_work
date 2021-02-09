package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.repositories.TaxSystemRepository;
import com.warehouse_accounting.services.interfaces.TaxSystemService;
import com.warehouse_accounting.util.ConverterDto;
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
        taxSystemRepository.save(ConverterDto.convertToModel(taxSystemDto));
    }

    @Override
    public void update(TaxSystemDto taxSystemDto) {
        taxSystemRepository.save(ConverterDto.convertToModel(taxSystemDto));
    }

    @Override
    public void deleteById(Long id) {
        taxSystemRepository.deleteById(id);
    }
}
