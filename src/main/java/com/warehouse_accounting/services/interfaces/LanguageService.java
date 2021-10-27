package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.LanguageDto;
import java.util.List;


public interface LanguageService {
    List<LanguageDto> getAll();

    LanguageDto getById(Long id);

    void create(LanguageDto languageDto);

    void update(LanguageDto languageDto);

    void deleteById(Long id);
}
