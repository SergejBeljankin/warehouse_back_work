package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.SelectorDto;
import com.warehouse_accounting.repositories.SelectorRepository;
import com.warehouse_accounting.services.interfaces.SelectorService;
import com.warehouse_accounting.util.ConverterDto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SelectorServiceImpl implements SelectorService {
    private final SelectorRepository selectorRepository;

    public SelectorServiceImpl(SelectorRepository selectorRepository) {
        this.selectorRepository = selectorRepository;
    }

    @Override
    public List<SelectorDto> getAll() {
        return selectorRepository.getAll();
    }

    @Override
    public SelectorDto getById(Long id) {
        return selectorRepository.getById(id);
    }

    @Override
    public void create(SelectorDto selectorDto) {
        selectorRepository.save(ConverterDto.convertToModel(selectorDto));
    }

    @Override
    public void update(SelectorDto selectorDto) {
        selectorRepository.save(ConverterDto.convertToModel(selectorDto));
    }

    @Override
    public void deleteById(Long id) {
        selectorRepository.deleteById(id);
    }
}
