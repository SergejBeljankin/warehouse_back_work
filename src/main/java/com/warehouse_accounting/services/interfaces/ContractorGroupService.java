package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.ContractorGroupDto;

import java.util.List;

public interface ContractorGroupService {
    List<ContractorGroupDto> getAll();

    ContractorGroupDto getById(Long id);

    void create(ContractorGroupDto contractorGroupDto);

    void update(ContractorGroupDto contractorGroupDto);

    void deleteById(Long id);
}
