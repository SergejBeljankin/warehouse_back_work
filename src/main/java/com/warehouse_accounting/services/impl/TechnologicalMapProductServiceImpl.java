package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TechnologicalMapProductDto;
import com.warehouse_accounting.repositories.TechnologicalMapProductRepository;
import com.warehouse_accounting.repositories.TechnologicalMapRepository;
import com.warehouse_accounting.services.interfaces.TechnologicalMapProductService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class implements interface {@link TechnologicalMapProductService}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
@Service
@Transactional
public class TechnologicalMapProductServiceImpl implements TechnologicalMapProductService {
    private final TechnologicalMapProductRepository technilogicalMapProductRepository;
    private final TechnologicalMapRepository technologicalMapRepository;

    public TechnologicalMapProductServiceImpl(TechnologicalMapProductRepository technilogicalMapProductRepository,
                                              TechnologicalMapRepository technologicalMapRepository) {
        this.technilogicalMapProductRepository = technilogicalMapProductRepository;
        this.technologicalMapRepository = technologicalMapRepository;
    }

    @Override
    public List<TechnologicalMapProductDto> getAll() {
        List<TechnologicalMapProductDto> technologicalMapProductDtos = technilogicalMapProductRepository.getAll();
        for (TechnologicalMapProductDto technologicalMapProductDto : technologicalMapProductDtos) {
            technologicalMapProductDto.setTechnologicalMapDto(
                    technologicalMapRepository.getById(technologicalMapProductDto.getTechnologicalMapDto().getId()));
            }
        return technologicalMapProductDtos;
    }

    @Override
    public TechnologicalMapProductDto getById(Long id) {
        TechnologicalMapProductDto technologicalMapProductDto = technilogicalMapProductRepository.getById(id);
        technologicalMapProductDto.setTechnologicalMapDto(
                    technologicalMapRepository.getById(technologicalMapProductDto.getTechnologicalMapDto().getId()));

        return technologicalMapProductDto;
    }

    @Override
    public void create(TechnologicalMapProductDto technologicalMapProductDto) {
        technilogicalMapProductRepository.save(ConverterDto.convertToModel(technologicalMapProductDto));
    }

    @Override
    public void update(TechnologicalMapProductDto technologicalMapProductDto) {
        technilogicalMapProductRepository.save(ConverterDto.convertToModel(technologicalMapProductDto));
    }

    @Override
    public void deleteById(Long id) {
        technilogicalMapProductRepository.deleteById(id);
    }
}
