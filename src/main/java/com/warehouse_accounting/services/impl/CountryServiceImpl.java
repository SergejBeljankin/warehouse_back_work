package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.CountryDto;
import com.warehouse_accounting.repositories.CountryRepository;
import com.warehouse_accounting.services.interfaces.CountryService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryDto> getAll() {
        return countryRepository.getAll();
    }

    @Override
    public CountryDto getById(Long id) {
        return countryRepository.getById(id);
    }

    @Override
    public void create(CountryDto countryDto) {
        countryRepository.save(ConverterDto.convertToModel(countryDto));
    }

    @Override
    public void update(CountryDto countryDto) {
        countryRepository.save(ConverterDto.convertToModel(countryDto));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);

    }
}
