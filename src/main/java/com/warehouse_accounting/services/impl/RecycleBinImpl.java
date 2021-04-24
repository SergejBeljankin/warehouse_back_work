package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.repositories.RecycleBinRepository;
import com.warehouse_accounting.services.interfaces.RecycleBin;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RecycleBinImpl implements RecycleBin {
    RecycleBinRepository recycleBinRepository;

    public RecycleBinImpl(RecycleBinRepository recycleBinRepository) {
        this.recycleBinRepository = recycleBinRepository;
    }

    @Override
    public RecycleBin getRecycleBinById(Long id) {
        System.out.println("=====================================================================");
        System.out.println((RecycleBin) recycleBinRepository.getRecycleBinById(1L));
        return (RecycleBin) recycleBinRepository.getRecycleBinById(1L);
    }
}
