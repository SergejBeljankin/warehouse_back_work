package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ProjectDto;
import com.warehouse_accounting.repositories.ProjectRepository;
import com.warehouse_accounting.services.interfaces.ProjectService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public ProjectDto getById(Long id) {
        return projectRepository.getById(id);
    }

    @Override
    public void create(ProjectDto projectDto) {
        projectRepository.save(ConverterDto.convertToModel(projectDto));
    }

    @Override
    public void update(ProjectDto projectDto) {
        projectRepository.save(ConverterDto.convertToModel(projectDto));
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
