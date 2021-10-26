package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.CustomerOrderDto;
import com.warehouse_accounting.repositories.CustomerOrderRepository;
import com.warehouse_accounting.services.interfaces.CustomerOrderService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository repository;

    public CustomerOrderServiceImpl(CustomerOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerOrderDto> getAll() {
        return repository.getAll();
    }

    @Override
    public CustomerOrderDto getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void create(CustomerOrderDto customerOrderDto) {
        repository.save(ConverterDto.convertToModel(customerOrderDto));
    }

    @Override
    public void update(CustomerOrderDto customerOrderDto) {
        repository.save(ConverterDto.convertToModel(customerOrderDto));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
