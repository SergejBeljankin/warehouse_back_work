package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.CustomerReturnsDto;
import com.warehouse_accounting.repositories.CustomerReturnsRepository;
import com.warehouse_accounting.services.interfaces.CustomerReturnsService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerReturnsServiceImpl implements CustomerReturnsService {

    private final CustomerReturnsRepository customerReturnsRepository;

    @Autowired
    public CustomerReturnsServiceImpl(CustomerReturnsRepository customerReturnsRepository) {
        this.customerReturnsRepository = customerReturnsRepository;
    }

    @Override
    public List<CustomerReturnsDto> getAll() {
        return customerReturnsRepository.getAll();
    }

    @Override
    public CustomerReturnsDto getById(Long id) {
        return customerReturnsRepository.getById(id);
    }

    @Override
    public void create(CustomerReturnsDto customerReturnsDto) {
        customerReturnsRepository.save(ConverterDto.convertToModel(customerReturnsDto));
    }

    @Override
    public void update(CustomerReturnsDto customerReturnsDto) {
        customerReturnsRepository.save(ConverterDto.convertToModel(customerReturnsDto));
    }

    @Override
    public void deleteById(Long id) {
        customerReturnsRepository.deleteById(id);
    }
}
