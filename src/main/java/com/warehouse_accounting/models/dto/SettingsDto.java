package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

@NoArgsConstructor
public class SettingsDto {
    public SettingsDto(Long id, EmployeeDto employeeDto, CompanyDto companyDto, WarehouseDto warehouseDto, ContractorDto customerDto, ContractorDto producerDto, ProjectDto projectDto, LanguageDto languageDto, PrintingDocumentsDto printingDocumentsDto, int numberOfAdditionalFieldsPerLine, StartScreenDto startScreenDto, boolean refreshReportsAuto, boolean signatureInLetters, NotificationsDto notificationsDto) {
        this.id = id;
        this.employeeDto = employeeDto;
        this.companyDto = companyDto;
        this.warehouseDto = warehouseDto;
        this.customerDto = customerDto;
        this.producerDto = producerDto;
        this.projectDto = projectDto;
        this.languageDto = languageDto;
        this.printingDocumentsDto = printingDocumentsDto;
        this.numberOfAdditionalFieldsPerLine = numberOfAdditionalFieldsPerLine;
        this.startScreenDto = startScreenDto;
        this.refreshReportsAuto = refreshReportsAuto;
        this.signatureInLetters = signatureInLetters;
        this.notificationsDto = notificationsDto;
    }

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
