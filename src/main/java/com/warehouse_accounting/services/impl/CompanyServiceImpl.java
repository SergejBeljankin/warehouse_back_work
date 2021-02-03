package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.services.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
Используем JpaRepository
Dto - это dto той сущности для которой создаётся сервис.
Конструирование Dto делаем в запросе к базе
List<Dto> getAll();

Dto getById(Long id);

void create(Dto dto);

void update(Dto dto);

void deleteById(Long id);
 */

public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository compRep;

    @Override
    public List<CompanyDto> getAll() {
        List<Company> companies =  compRep.findAll();
        return null;
    }

    @Override
    public CompanyDto getById(Long id) {
        return null;
    }

    @Override
    public void create(CompanyDto dto) {

    }

    @Override
    public void update(CompanyDto dto) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
