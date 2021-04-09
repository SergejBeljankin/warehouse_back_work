package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto;

import java.util.List;

/**
 * This is the interface for the service for the entity {@link com.warehouse_accounting.models.TechnologicalMapMaterial}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
public interface TechnologicalMapMaterialService {

    List<TechnologicalMapMaterialDto> getAll();

    TechnologicalMapMaterialDto getById(Long id);

    void create(TechnologicalMapMaterialDto technologicalMapMaterialDto);

    void update(TechnologicalMapMaterialDto technologicalMapMaterialDto);

    void deleteById(Long id);
}
