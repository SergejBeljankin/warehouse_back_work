package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.TypeOfContractor;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.repositories.TypeOfContractorRepository;
import com.warehouse_accounting.services.interfaces.TypeOfContractorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeOfContractorServiceImpl implements TypeOfContractorService {
    private TypeOfContractorRepository tcRep;

    @Override
    public List<TypeOfContractorDto> getAll() {
        return tcRep.getAll();
    }

    @Override
    public TypeOfContractorDto getById(Long id) {
        return tcRep.getById(id);
    }

    @Override
    public void create(TypeOfContractorDto tcDTO) {
        tcRep.save(
                TypeOfContractor.builder()
                        .name(tcDTO.getName())
                        .sortNumber(tcDTO.getSortNumber())
                        .build()

        );
    }

    @Override
    public void deleteByID(Long id){
        tcRep.deleteById(id);
    }

    @Override
    public void update(TypeOfContractorDto tcDTO) {
        tcRep.save(
                TypeOfContractor.builder()
                        .id(tcDTO.getId())
                        .name(tcDTO.getName())
                        .sortNumber(tcDTO.getSortNumber())
                        .build()
        );
    }
}