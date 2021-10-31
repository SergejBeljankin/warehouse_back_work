package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.SettingsDto;
import java.util.List;

public interface SettingsService {

    List<SettingsDto> getAll();

    SettingsDto getByIdEmployee(Long id);

    void create(SettingsDto settingsDto);

    void update(SettingsDto settingsDto);

    void deleteById(Long id);
}
