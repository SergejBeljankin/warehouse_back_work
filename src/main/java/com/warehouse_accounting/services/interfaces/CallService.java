package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.CallDto;

import java.util.List;

public interface CallService {
    List<CallDto> getAll();

    CallDto getById(Long id);

    void create(CallDto bankAccountDto);

    void update(CallDto bankAccountDto);

    void deleteById(Long id);
}