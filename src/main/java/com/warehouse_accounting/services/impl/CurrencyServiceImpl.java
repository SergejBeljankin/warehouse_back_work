package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.CurrencyDto;
import com.warehouse_accounting.repositories.CurrencyRepository;
import com.warehouse_accounting.services.interfaces.CurrencyService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<CurrencyDto> getAll() {
        return currencyRepository.getAll();
    }

    @Override
    public CurrencyDto getById(Long id) {
        return currencyRepository.getById(id);
    }

    @Override
    public void create(CurrencyDto dto) {

        currencyRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(CurrencyDto dto) {
        currencyRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        currencyRepository.deleteById(id);
    }




}
