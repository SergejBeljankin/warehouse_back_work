package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.SettingsDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.LanguageRepository;
import com.warehouse_accounting.repositories.NotificationsRepository;
import com.warehouse_accounting.repositories.PrintingDocumentsRepository;
import com.warehouse_accounting.repositories.ProjectRepository;
import com.warehouse_accounting.repositories.SelectorRepository;
import com.warehouse_accounting.repositories.SettingsRepository;
import com.warehouse_accounting.repositories.StartScreenRepository;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.SettingsService;
import java.util.List;

public class SettingServiceImpl implements SettingsService {
    private final SettingsRepository settingsRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final WarehouseRepository warehouseRepository;
    private final ContractorRepository contractorRepository;
    private final ProjectRepository projectRepository;
    private final LanguageRepository languageRepository;
    private final PrintingDocumentsRepository printingDocumentsRepository;
    private final StartScreenRepository startScreenRepository;
    private final NotificationsRepository notificationsRepository;
    private final SelectorRepository selectorRepository;

    public SettingServiceImpl(SettingsRepository settingsRepository, EmployeeRepository employeeRepository,
                              CompanyRepository companyRepository,
                              WarehouseRepository warehouseRepository,
                              ContractorRepository contractorRepository,
                              ProjectRepository projectRepository,
                              LanguageRepository languageRepository,
                              PrintingDocumentsRepository printingDocumentsRepository,
                              StartScreenRepository startScreenRepository,
                              NotificationsRepository notificationsRepository,
                              SelectorRepository selectorRepository) {
        this.settingsRepository = settingsRepository;
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.warehouseRepository = warehouseRepository;
        this.contractorRepository = contractorRepository;
        this.projectRepository = projectRepository;
        this.languageRepository = languageRepository;
        this.printingDocumentsRepository = printingDocumentsRepository;
        this.startScreenRepository = startScreenRepository;
        this.notificationsRepository = notificationsRepository;
        this.selectorRepository = selectorRepository;
    }



    @Override
    public List<SettingsDto> getAll() {
        return settingsRepository.getAll();
    }

    @Override
    public SettingsDto getByIdEmployee(Long id) {
        return settingsRepository.getByIdEmployee(id);
    }

    @Override
    public void create(SettingsDto settingsDto) {

    }

    @Override
    public void update(SettingsDto settingsDto) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
