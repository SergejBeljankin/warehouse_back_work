package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.repositories.TechnologicalMapRepository;
import com.warehouse_accounting.repositories.TechnologicalOperationRepository;
import com.warehouse_accounting.services.interfaces.TechnologicalOperationService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TechnologicalOperationServiceImpl implements TechnologicalOperationService {

    private final TechnologicalOperationRepository technologicalOperationRepository;
    private final TechnologicalMapRepository technologicalMapRepository;

    public TechnologicalOperationServiceImpl(TechnologicalOperationRepository technologicalOperationRepository, TechnologicalMapRepository technologicalMapRepository) {
        this.technologicalOperationRepository = technologicalOperationRepository;
        this.technologicalMapRepository = technologicalMapRepository;
    }

    @Override
    public List<TechnologicalOperationDto> getAll(){
        List<TechnologicalOperationDto> technologicalOperationDtos = technologicalOperationRepository.getAll();
        for (TechnologicalOperationDto technologicalOperationDto: technologicalOperationDtos){
            technologicalOperationDto.setTechnologicalMapDtoObj(technologicalMapRepository.getById(technologicalOperationDto.getTechnologicalMapDtoObj().getId()
            ));
        }
        return technologicalOperationDtos;
    }

    @Override
    public TechnologicalOperationDto getById(Long id) {
        TechnologicalOperationDto technologicalOperationDto = technologicalOperationRepository.getById(id);
        technologicalOperationDto.setTechnologicalMapDtoObj(technologicalMapRepository.getById(technologicalOperationDto.getTechnologicalMapDtoObj().getId()));
        return technologicalOperationDto;
    }

    @Override
    public void create(TechnologicalOperationDto technologicalOperationDto) {
        technologicalOperationRepository.save(ConverterDto.convertToModel(technologicalOperationDto));
    }

    @Override
    public void update(TechnologicalOperationDto technologicalOperationDto) {
        technologicalOperationRepository.save(ConverterDto.convertToModel(technologicalOperationDto));
    }

    @Override
    public void deleteById(Long id) {
        technologicalOperationRepository.deleteById(id);
    }
}
