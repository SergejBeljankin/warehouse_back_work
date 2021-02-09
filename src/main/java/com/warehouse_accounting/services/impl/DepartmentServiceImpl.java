package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.util.ConverterDto;
import com.warehouse_accounting.repositories.DepartmentRepository;
import com.warehouse_accounting.services.interfaces.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.warehouse_accounting.models.dto.DepartmentDto;


import java.util.List;


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository.getAll();
    }

    @Override
    public DepartmentDto getById(Long id) {
        return departmentRepository.getById(id);
    }

    @Override
    public void create(DepartmentDto departmentDto) {
        departmentRepository.save(ConverterDto.convertToModel(departmentDto));
    }

    @Override
    public void update(DepartmentDto departmentDto) {
        departmentRepository.save(ConverterDto.convertToModel(departmentDto));
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }



}
