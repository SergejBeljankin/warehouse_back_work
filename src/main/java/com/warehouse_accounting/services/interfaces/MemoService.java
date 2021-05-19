package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.MemoDto;

import java.util.List;

public interface MemoService {
    List<MemoDto> getAll();

    MemoDto getById(Long id);

    void create(MemoDto memoDto);

    void update(MemoDto memoDto);

    void deleteById(Long id);
}