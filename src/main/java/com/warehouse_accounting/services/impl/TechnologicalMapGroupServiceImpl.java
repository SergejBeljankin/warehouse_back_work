package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;
import com.warehouse_accounting.repositories.TechnologicalMapGroupRepository;
import com.warehouse_accounting.services.interfaces.TechnologicalMapGroupService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class implements interface {@link TechnologicalMapGroupService}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
@Service
@Transactional
public class TechnologicalMapGroupServiceImpl implements TechnologicalMapGroupService {

    private final TechnologicalMapGroupRepository technologicalMapGroupRepository;

    public TechnologicalMapGroupServiceImpl(TechnologicalMapGroupRepository technologicalMapGroupRepository) {
        this.technologicalMapGroupRepository = technologicalMapGroupRepository;
    }

    @Override
    public List<TechnologicalMapGroupDto> getAll() {
        return technologicalMapGroupRepository.getAll();
    }

    @Override
    public TechnologicalMapGroupDto getById(Long id) {
        return technologicalMapGroupRepository.getById(id);
    }

    @Override
    public void create(TechnologicalMapGroupDto technologicalMapGroupDto) {
        technologicalMapGroupRepository.save(ConverterDto.convertToModel(technologicalMapGroupDto));
    }

    @Override
    public void update(TechnologicalMapGroupDto technologicalMapGroupDto) {
        technologicalMapGroupRepository.save(ConverterDto.convertToModel(technologicalMapGroupDto));
    }

    @Override
    public void deleteById(Long id) {
        technologicalMapGroupRepository.deleteById(id);
    }
}
