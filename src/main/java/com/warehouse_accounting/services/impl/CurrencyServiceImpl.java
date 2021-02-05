package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.Currency;
import com.warehouse_accounting.models.dto.CurrencyDto;
import com.warehouse_accounting.repositories.CurrencyRepository;
import com.warehouse_accounting.services.interfaces.CurrencyService;
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
        currencyRepository.save(convertToModel(dto));
    }

    @Override
    public void update(CurrencyDto dto) {
        currencyRepository.save(convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        currencyRepository.deleteById(id);
    }

    private Currency convertToModel(CurrencyDto currencyDto) {
        return Currency.builder()
                .id(currencyDto.getId())
                .fullName(currencyDto.getFullName())
                .shortName(currencyDto.getShortName())
                .sortNumber(currencyDto.getSortNumber())
                .digitalCode(currencyDto.getDigitalCode())
                .letterCode(currencyDto.getLetterCode())
                .build();
    }

    private CurrencyDto convertToDto(Currency currency) {
        return CurrencyDto.builder()
                .id(currency.getId())
                .fullName(currency.getFullName())
                .shortName(currency.getShortName())
                .sortNumber(currency.getSortNumber())
                .digitalCode(currency.getDigitalCode())
                .letterCode(currency.getLetterCode())
                .build();
    }


}
