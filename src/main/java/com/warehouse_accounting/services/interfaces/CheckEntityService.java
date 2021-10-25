package com.warehouse_accounting.services.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckEntityService {
    void checkExist(Long id, JpaRepository repository, String objectName);
}
