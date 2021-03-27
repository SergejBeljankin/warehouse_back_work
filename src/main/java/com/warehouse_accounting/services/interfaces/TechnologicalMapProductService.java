package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.TechnologicalMapProductDto;

import java.util.List;

/**
 * This is the interface for the service for the entity {@link com.warehouse_accounting.models.TechnologicalMapProduct}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
public interface TechnologicalMapProductService {
    List<TechnologicalMapProductDto> getAll();
    TechnologicalMapProductDto getById(Long id);
    void create(TechnologicalMapProductDto technologicalMapProductDto);
    void update(TechnologicalMapProductDto v);
    void deleteById(Long id);
}
