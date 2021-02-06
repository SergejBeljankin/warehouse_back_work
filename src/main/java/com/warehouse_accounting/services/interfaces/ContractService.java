package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.contractDto;

import java.util.List;

public interface ContractService {
    List<contractDto> getAll();

    contractDto getById(Long id);

    void create(contractDto contractDto);

    void update(contractDto contractDto);

    void deleteById(Long id);
}
