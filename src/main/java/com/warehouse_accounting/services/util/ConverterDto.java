package com.warehouse_accounting.services.util;

import com.warehouse_accounting.models.Currency;
import com.warehouse_accounting.models.dto.CurrencyDto;

public class ConverterDto {
    public static Currency convertToModel(CurrencyDto currencyDto) {
        return Currency.builder()
                .id(currencyDto.getId())
                .fullName(currencyDto.getFullName())
                .shortName(currencyDto.getShortName())
                .sortNumber(currencyDto.getSortNumber())
                .digitalCode(currencyDto.getDigitalCode())
                .letterCode(currencyDto.getLetterCode())
                .build();
    }

    public static CurrencyDto convertToDto(Currency currency) {
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
