package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.RequisitesDto;
import com.warehouse_accounting.repositories.RequisitesRepository;
import com.warehouse_accounting.services.interfaces.RequisitesService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RequisitesServiceImpl implements RequisitesService {

    private final RequisitesRepository requisitesRepository;

    @Autowired
    public RequisitesServiceImpl(RequisitesRepository requisitesRepository) {
        this.requisitesRepository = requisitesRepository;
    }

    @Override
    public List<RequisitesDto> getAll() {
        return requisitesRepository.getAll();
    }

    @Override
    public RequisitesDto getById(Long id) {
        return requisitesRepository.getById(id);
    }

    @Override
    public void create(RequisitesDto requisitesDto) {
        requisitesRepository.save(ConverterDto.convertToModel(requisitesDto));
    }

    @Override
    public void update(RequisitesDto requisitesDto) {
        requisitesRepository.save(ConverterDto.convertToModel(requisitesDto));
    }

    @Override
    public void deleteById(Long id) {
        requisitesRepository.deleteById(id);
    }
}
