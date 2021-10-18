package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.Tariff;
import com.warehouse_accounting.models.dto.TariffDto;
import com.warehouse_accounting.repositories.TariffRepository;
import com.warehouse_accounting.services.interfaces.TariffService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<TariffDto> getAll() {
        return tariffRepository.getAll();
    }

    @Override
    public TariffDto getById(Long id) {
        return tariffRepository.getById(id);
    }

    @Override
    public void create(TariffDto tariffDto) {
        tariffRepository.save(ConverterDto.convertToModel(tariffDto));
    }

    @Override
    public void update(TariffDto tariffDto) {
        tariffRepository.save(ConverterDto.convertToModel(tariffDto));
    }

    @Override
    public void deleteById(Long id) {
        tariffRepository.deleteById(id);
    }
}
