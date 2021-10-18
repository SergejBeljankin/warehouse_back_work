package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.BonusTransactionDto;

import java.util.List;

public interface BonusTransactionService {

    List<BonusTransactionDto> getAll();

    BonusTransactionDto getById(Long id);

    void create(BonusTransactionDto dto);

    void update(BonusTransactionDto dto);

    void deleteById(Long id);

}
