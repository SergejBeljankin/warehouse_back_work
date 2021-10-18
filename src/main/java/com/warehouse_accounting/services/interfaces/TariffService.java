package com.warehouse_accounting.services.interfaces;


import com.warehouse_accounting.models.dto.TariffDto;

import java.util.List;

public interface TariffService {

    List<TariffDto> getAll();

    TariffDto getById(Long id);

    void create(TariffDto tariffDto);

    void update(TariffDto tariffDto);

    void deleteById(Long id);
}
