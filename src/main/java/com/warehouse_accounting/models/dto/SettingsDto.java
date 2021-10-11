package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.Notifications;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    private boolean RefreshReportsAuto;

    private boolean SignatureInLetters;

    // Уведомления
    private Notifications notifications;

}
