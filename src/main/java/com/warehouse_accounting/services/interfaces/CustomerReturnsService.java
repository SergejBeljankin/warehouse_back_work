package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.CustomerReturnsDto;

import java.util.List;

public interface CustomerReturnsService {

    List<CustomerReturnsDto> getAll();

    CustomerReturnsDto getById(Long id);

    void create(CustomerReturnsDto customerReturnsDto);

    void update(CustomerReturnsDto customerReturnsDto);

    void deleteById(Long id);
}
