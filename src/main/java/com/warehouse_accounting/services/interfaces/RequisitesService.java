package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.RequisitesDto;

import java.util.List;

public interface RequisitesService {
    List<RequisitesDto> getAll();

    RequisitesDto getById(Long id);

    void create(RequisitesDto dto);

    void update(RequisitesDto dto);

    void deleteById(Long id);
}
