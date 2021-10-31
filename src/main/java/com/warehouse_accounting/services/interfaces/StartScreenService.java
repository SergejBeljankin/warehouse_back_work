package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.StartScreenDto;
import java.util.List;

public interface StartScreenService {
    List<StartScreenDto> getAll();

    StartScreenDto getById(Long id);

    void create(StartScreenDto startScreenDto);

    void update(StartScreenDto startScreenDto);

    void deleteById(Long id);
}
