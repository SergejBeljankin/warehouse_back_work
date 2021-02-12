package com.warehouse_accounting.services;

import com.warehouse_accounting.repositories.UnitRepository;
import com.warehouse_accounting.util.exception.NotFoundEntityException;
import org.springframework.stereotype.Service;

@Service
public class CheckEntityService {

    private final UnitRepository unitRepository;

    public CheckEntityService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    //replaced method isExist() with existsById()
    public void checkExistUnitById(Long unitId) {
        if (!unitRepository.existsById(unitId)) {
            throw new NotFoundEntityException("Ед. измерения с id=" + unitId + ", не найдена");
        }
    }

}
