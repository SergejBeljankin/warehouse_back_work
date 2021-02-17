package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TypeOfPriceDto;
import com.warehouse_accounting.repositories.TypeOfPriceRepository;
import com.warehouse_accounting.services.interfaces.TypeOfPriceService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TypeOfPriceServiceImpl implements TypeOfPriceService {

    private final TypeOfPriceRepository typeOfPriceRepository;

    public TypeOfPriceServiceImpl(TypeOfPriceRepository repository) {
        this.typeOfPriceRepository = repository;
    }

    @Override
    public List<TypeOfPriceDto> getAll() {
        return typeOfPriceRepository.getAll();
    }

    @Override
    public TypeOfPriceDto getById(Long id) {
        return typeOfPriceRepository.getById(id);
    }

    @Override
    public void create(TypeOfPriceDto typeOfPriceDto) {
        typeOfPriceRepository.save(ConverterDto.convertToModel(typeOfPriceDto));
    }

    @Override
    public void update(TypeOfPriceDto typeOfPriceDto) {
        typeOfPriceRepository.save(ConverterDto.convertToModel(typeOfPriceDto));
    }

    @Override
    public void deleteById(Long id) {
        typeOfPriceRepository.deleteById(id);
    }
}