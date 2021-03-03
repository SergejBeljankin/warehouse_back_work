package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.TransferDto;

import java.util.List;

public interface TransferService {
    List<TransferDto> getAll();

    TransferDto getById(Long id);

    void create(TransferDto dto);

    void update(TransferDto dto);

    void deleteById(Long id);
}
