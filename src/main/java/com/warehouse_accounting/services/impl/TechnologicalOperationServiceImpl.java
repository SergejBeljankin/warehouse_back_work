package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.repositories.TaskRepository;
import com.warehouse_accounting.repositories.TechnologicalOperationRepository;
import com.warehouse_accounting.services.interfaces.TechnologicalOperationService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TechnologicalOperationServiceImpl implements TechnologicalOperationService {

    private final TechnologicalOperationRepository technologicalOperationRepository;
    private final TaskRepository taskRepository;

    public TechnologicalOperationServiceImpl(TechnologicalOperationRepository technologicalOperationRepository,
                                             TaskRepository taskRepository) {
        this.technologicalOperationRepository = technologicalOperationRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TechnologicalOperationDto> getAll() {
        List<TechnologicalOperationDto> technologicalOperationDtos = technologicalOperationRepository.getAll();
        for (TechnologicalOperationDto technologicalOperationDto : technologicalOperationDtos) {
            technologicalOperationDto.setTasks(taskRepository
                    .getListTaskById(technologicalOperationDto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
        }

        return technologicalOperationDtos;
    }

    @Override
    public TechnologicalOperationDto getById(Long id) {
        TechnologicalOperationDto technologicalOperationDto = technologicalOperationRepository.getById(id);
        technologicalOperationDto.setTasks(taskRepository
                .getListTaskById(technologicalOperationDto.getId())
                .stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList()));

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
