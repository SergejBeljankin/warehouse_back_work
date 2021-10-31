package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.LanguageDto;
import com.warehouse_accounting.repositories.LanguageRepository;
import com.warehouse_accounting.services.interfaces.LanguageService;
import com.warehouse_accounting.util.ConverterDto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {
    private  final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageDto> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public LanguageDto getById(Long id) {
        return languageRepository.getById(id);
    }

    @Override
    public void create(LanguageDto languageDto) {
        languageRepository.save(ConverterDto.convertToModel(languageDto));
    }

    @Override
    public void update(LanguageDto languageDto) {
        languageRepository.save(ConverterDto.convertToModel(languageDto));
    }

    @Override
    public void deleteById(Long id) {
        languageRepository.deleteById(id);
    }
}
