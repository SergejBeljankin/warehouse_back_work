package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;

import java.util.List;

/**
 * This is the interface for the service for the entity {@link com.warehouse_accounting.models.TechnologicalMapGroup}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
public interface TechnologicalMapGroupService {
    List<TechnologicalMapGroupDto> getAll();

    TechnologicalMapGroupDto getById(Long id);

    void create(TechnologicalMapGroupDto technologicalMapGroupDto);

    void update(TechnologicalMapGroupDto technologicalMapGroupDto);

    void deleteById(Long id);
}
