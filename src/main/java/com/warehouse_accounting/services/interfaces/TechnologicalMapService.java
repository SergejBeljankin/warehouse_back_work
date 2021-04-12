package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.TechnologicalMapDto;

import java.util.List;

/**
 * This is the interface for the service for the entity {@link com.warehouse_accounting.models.TechnologicalMap}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
public interface TechnologicalMapService {

    List<TechnologicalMapDto> getAll();

    TechnologicalMapDto getById(Long id);

    void create(TechnologicalMapDto technologicalMapDto);

    void update(TechnologicalMapDto technologicalMapDto);

    void deleteById(Long id);
}
