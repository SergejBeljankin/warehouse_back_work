package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Settings;
import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.SettingsDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.SettingsDto(" +
            "s.id, " +
            "s.employee.id, " +
            "s.company.id, " +
            "s.warehouse.id, " +
            "s.customer.id, " +
            "s.producer.id, " +
            "s.project.id, " +
            "s.language.id, " +
            "s.printingDocuments.id, " +
            "s.numberOfAdditionalFieldsPerLine, " +
            "s.startScreen.id, " +
            "s.refreshReportsAuto, " +
            "s.signatureInLetters, " +
            "s.notifications.id " +
            ")" +
            "FROM Settings s")
    List<SettingsDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.SettingsDto(" +
            "s.id, " +
            "s.employee.id, " +
            "s.company.id, " +
            "s.warehouse.id, " +
            "s.customer.id, " +
            "s.producer.id, " +
            "s.project.id, " +
            "s.language.id, " +
            "s.printingDocuments.id, " +
            "s.numberOfAdditionalFieldsPerLine, " +
            "s.startScreen.id, " +
            "s.refreshReportsAuto, " +
            "s.signatureInLetters, " +
            "s.notifications.id " +
            ")" +
            "FROM Settings s WHERE s.id = :id")
    SettingsDto getById(@Param("id") Long id);


}