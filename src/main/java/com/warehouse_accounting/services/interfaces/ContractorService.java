package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.ContractorGetALLDto;

import java.util.List;

public interface ContractorService {

    List<ContractorGetALLDto> getAll();

    ContractorDto getById(Long id);

    void create(ContractorDto contractorDto);

    void update(ContractorDto contractorDto);

    void deleteById(Long id);
}
