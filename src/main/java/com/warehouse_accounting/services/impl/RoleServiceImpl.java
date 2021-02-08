package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.services.interfaces.RoleService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> getAll() {
        return roleRepository.getAll();
    }

    @Override
    public RoleDto getById(Long id) {
        return roleRepository.getById(id);
    }

    @Override
    public void create(RoleDto dto) {
        roleRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(RoleDto dto) {
        roleRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
