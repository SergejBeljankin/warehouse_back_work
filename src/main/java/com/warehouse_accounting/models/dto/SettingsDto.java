package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingsDto {

    private Long id;

    private EmployeeDto employeeDto;

    private CompanyDto companyDto;

    private WarehouseDto warehouseDto;

    private ContractorDto customerDto;

    private ContractorDto producerDto;

    private ProjectDto projectDto;

    // Настройки
    private LanguageDto languageDto;

    private PrintingDocumentsDto printingDocumentsDto;

    private int numberOfAdditionalFieldsPerLine;

    private StartScreenDto startScreenDto;

    private boolean refreshReportsAuto;

    private boolean signatureInLetters;

    // Уведомления
    private NotificationsDto notificationsDto;


}
