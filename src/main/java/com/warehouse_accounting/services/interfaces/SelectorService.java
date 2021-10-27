package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.SelectorDto;
import java.util.List;

public interface SelectorService {
    List<SelectorDto> getAll();

    SelectorDto getById(Long id);

    void create(SelectorDto selectorDto);

    void update(SelectorDto selectorDto);

    void deleteById(Long id);
}
