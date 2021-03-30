package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.repositories.TechnologicalMapMaterialRepository;
import com.warehouse_accounting.repositories.TechnologicalMapProductRepository;
import com.warehouse_accounting.repositories.TechnologicalMapRepository;
import com.warehouse_accounting.services.interfaces.TechnologicalMapService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements interface {@link TechnologicalMapService}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
@Service
@Transactional
public class TechnologicalMapServiceImpl implements TechnologicalMapService {
    private final TechnologicalMapRepository technologicalMapRepository;
    private final TechnologicalMapProductRepository technologicalMapProductRepository;
    private final TechnologicalMapMaterialRepository technologicalMapMaterialRepository;

    public TechnologicalMapServiceImpl(TechnologicalMapRepository technologicalMapRepository,
                                       TechnologicalMapProductRepository technologicalMapProductRepository,
                                       TechnologicalMapMaterialRepository technologicalMapMaterialRepository) {
        this.technologicalMapRepository = technologicalMapRepository;
        this.technologicalMapProductRepository = technologicalMapProductRepository;
        this.technologicalMapMaterialRepository = technologicalMapMaterialRepository;
    }

    @Override
    public List<TechnologicalMapDto> getAll() {
        List<TechnologicalMapDto> technologicalMapDtos = technologicalMapRepository.getAll();
        for (TechnologicalMapDto technologicalMapDto : technologicalMapDtos) {
            technologicalMapDto.setFinishedProducts(technologicalMapProductRepository
                    .getListTechnologicalMapProductById(technologicalMapDto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
            technologicalMapDto.setMaterials(technologicalMapMaterialRepository
                    .getListTechnologicalMapMaterialById(technologicalMapDto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
        }

        return technologicalMapDtos;
    }

    @Override
    public TechnologicalMapDto getById(Long id) {
        TechnologicalMapDto technologicalMapDto = technologicalMapRepository.getById(id);
        technologicalMapDto.setFinishedProducts(technologicalMapProductRepository
                .getListTechnologicalMapProductById(technologicalMapDto.getId())
                .stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList()));
        technologicalMapDto.setMaterials(technologicalMapMaterialRepository
                .getListTechnologicalMapMaterialById(technologicalMapDto.getId())
                .stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList()));
        return technologicalMapDto;
    }

    @Override
    public void create(TechnologicalMapDto technologicalMapDto) {
        technologicalMapRepository.save(ConverterDto.convertToModel(technologicalMapDto));
    }

    @Override
    public void update(TechnologicalMapDto technologicalMapDto) {
        technologicalMapRepository.save(ConverterDto.convertToModel(technologicalMapDto));
    }

    @Override
    public void deleteById(Long id) {
        technologicalMapRepository.deleteById(id);
    }
}
