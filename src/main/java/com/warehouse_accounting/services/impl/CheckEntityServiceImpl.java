package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.repositories.UnitRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.util.exception.NotFoundEntityException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckEntityServiceImpl implements CheckEntityService {

    private final UnitRepository unitRepository;

    public CheckEntityServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public void checkExistUnitById(Long unitId) {
        if (!unitRepository.existsById(unitId)) {
            throw new NotFoundEntityException("Ед. измерения с id=" + unitId + ", не найдена");
        }
    }
}
