package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto;
import com.warehouse_accounting.repositories.TechnologicalMapMaterialRepository;
import com.warehouse_accounting.repositories.TechnologicalMapRepository;
import com.warehouse_accounting.services.interfaces.TechnologicalMapMaterialService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class implements interface {@link TechnologicalMapMaterialService}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
@Service
@Transactional
public class TechnologicalMapMaterialServiceImpl implements TechnologicalMapMaterialService {
    private final TechnologicalMapMaterialRepository technologicalMapMaterialRepository;
    private final TechnologicalMapRepository technologicalMapRepository;

    public TechnologicalMapMaterialServiceImpl(TechnologicalMapMaterialRepository technologicalMapMaterialRepository,
                                               TechnologicalMapRepository technologicalMapRepository) {
        this.technologicalMapMaterialRepository = technologicalMapMaterialRepository;
        this.technologicalMapRepository = technologicalMapRepository;
    }

    @Override
    public List<TechnologicalMapMaterialDto> getAll() {
        List<TechnologicalMapMaterialDto> technologicalMapMaterialDtos = technologicalMapMaterialRepository.getAll();
        for (TechnologicalMapMaterialDto technologicalMapMaterialDto : technologicalMapMaterialDtos) {
            technologicalMapMaterialDto.setTechnologicalMapDto(
                    technologicalMapRepository.getById(technologicalMapMaterialDto.getTechnologicalMapDto().getId()));
        }
        return technologicalMapMaterialDtos;
    }

    @Override
    public TechnologicalMapMaterialDto getById(Long id) {
        TechnologicalMapMaterialDto technologicalMapMaterialDto = technologicalMapMaterialRepository.getById(id);
        technologicalMapMaterialDto.setTechnologicalMapDto(
                technologicalMapRepository.getById(technologicalMapMaterialDto.getTechnologicalMapDto().getId()));

        return technologicalMapMaterialDto;
    }

    @Override
    public void create(TechnologicalMapMaterialDto technologicalMapMaterialDto) {
        technologicalMapMaterialRepository.save(ConverterDto.convertToModel(technologicalMapMaterialDto));
    }

    @Override
    public void update(TechnologicalMapMaterialDto technologicalMapMaterialDto) {
        technologicalMapMaterialRepository.save(ConverterDto.convertToModel(technologicalMapMaterialDto));
    }

    @Override
    public void deleteById(Long id) {
        technologicalMapMaterialRepository.deleteById(id);
    }
}
