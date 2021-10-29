package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.CommissionReportsDto;

import java.util.List;

public interface CommissionReportsService {
    List<CommissionReportsDto> getAll();

    CommissionReportsDto getById(Long id);

    void create(CommissionReportsDto commissionReportsDto);

    void update(CommissionReportsDto commissionReportsDto);

    void deleteById(Long id);
}

