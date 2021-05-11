package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.ProjectDto;
import com.warehouse_accounting.models.dto.RecycleBinDto;

import java.util.List;
import java.util.UUID;

public interface RecycleBinService {

    List<RecycleBinDto> getAll();

    RecycleBinDto getById(Long id);

    void create(RecycleBinDto recycleBinDto);

    void update(RecycleBinDto recycleBinDto);

    void deleteById(Long id);
}
