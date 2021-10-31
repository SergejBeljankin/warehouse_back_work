package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.exceptions.NotFoundEntityException;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CheckEntityServiceImpl implements CheckEntityService {
    @Override
    public void checkExist(Long id, JpaRepository repository, String objectName) {
        if(!repository.existsById(id)) {
            throw new NotFoundEntityException(objectName + " с id=" + id + " не найден");
        }
    }


    public void checkExistCustomerReturnsById(Long Id){

    }
    /*

     */
    public void checkExistSettingsById(Long settingsId){

    }

    public void checkExistLanguageById(Long settingsId){

    }

    public void checkExistPrintingDocumentsById(Long printingDocumentsId){

    }

    public void checkExistStartScreenById(Long startScreenId){

    }

    public void checkExistNotificationsById(Long notificationsId){

    }
}