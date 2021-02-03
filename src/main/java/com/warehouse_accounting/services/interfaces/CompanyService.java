package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.CompanyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    List<CompanyDto> getAll();

    CompanyDto getById(Long id);

    void create(CompanyDto dto);

    void update(CompanyDto dto);

    void deleteById(Long id);
}
