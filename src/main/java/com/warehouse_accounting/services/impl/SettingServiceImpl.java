package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.SettingsDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.LanguageRepository;
import com.warehouse_accounting.repositories.NotificationsRepository;
import com.warehouse_accounting.repositories.PrintingDocumentsRepository;
import com.warehouse_accounting.repositories.ProjectRepository;
import com.warehouse_accounting.repositories.SettingsRepository;
import com.warehouse_accounting.repositories.StartScreenRepository;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.SettingsService;
import com.warehouse_accounting.util.ConverterDto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SettingServiceImpl implements SettingsService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final WarehouseRepository warehouseRepository;
    private final ContractorRepository contractorRepository;
    private final ProjectRepository projectRepository;
    // MyClasses
    private final SettingsRepository settingsRepository;
    private final LanguageRepository languageRepository;
    private final PrintingDocumentsRepository printingDocumentsRepository;
    private final StartScreenRepository startScreenRepository;
    private final NotificationsRepository notificationsRepository;

    public SettingServiceImpl(SettingsRepository settingsRepository,
                              EmployeeRepository employeeRepository,
                              CompanyRepository companyRepository,
                              WarehouseRepository warehouseRepository,
                              ContractorRepository contractorRepository,
                              ProjectRepository projectRepository,
                              LanguageRepository languageRepository,
                              PrintingDocumentsRepository printingDocumentsRepository,
                              StartScreenRepository startScreenRepository,
                              NotificationsRepository notificationsRepository) {
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
    }



    @Override
    public List<SettingsDto> getAll() {
        List<SettingsDto> settingsDtos = settingsRepository.getAll();
        for (SettingsDto settingsDto: settingsDtos) {
            settingsDto.setEmployeeDto(employeeRepository.getById(settingsDto.getEmployeeDto().getId()));
            settingsDto.setCompanyDto(companyRepository.getById(settingsDto.getCompanyDto().getId()));
            settingsDto.setWarehouseDto(warehouseRepository.getById(settingsDto.getWarehouseDto().getId()));
            settingsDto.setCustomerDto(contractorRepository.getById(settingsDto.getCustomerDto().getId()));
            settingsDto.setProducerDto(contractorRepository.getById(settingsDto.getProducerDto().getId()));
            settingsDto.setProjectDto(projectRepository.getById(settingsDto.getProjectDto().getId()));
            settingsDto.setLanguageDto(languageRepository.getById(settingsDto.getLanguageDto().getId()));
            settingsDto.setPrintingDocumentsDto(printingDocumentsRepository.getById(settingsDto.getPrintingDocumentsDto().getId()));
            settingsDto.setStartScreenDto(startScreenRepository.getById(settingsDto.getStartScreenDto().getId()));
            settingsDto.setNotificationsDto(notificationsRepository.getById(settingsDto.getNotificationsDto().getId()));
        }
        return settingsDtos;
    }

    @Override
    public SettingsDto getByIdEmployee(Long id) {
        SettingsDto settingsDto = settingsRepository.getByIdEmployee(id);
        settingsDto.setEmployeeDto(employeeRepository.getById(settingsDto.getEmployeeDto().getId()));
        settingsDto.setCompanyDto(companyRepository.getById(settingsDto.getCompanyDto().getId()));
        settingsDto.setWarehouseDto(warehouseRepository.getById(settingsDto.getWarehouseDto().getId()));
        settingsDto.setCustomerDto(contractorRepository.getById(settingsDto.getCustomerDto().getId()));
        settingsDto.setProducerDto(contractorRepository.getById(settingsDto.getProducerDto().getId()));
        settingsDto.setProjectDto(projectRepository.getById(settingsDto.getProjectDto().getId()));
        settingsDto.setLanguageDto(languageRepository.getById(settingsDto.getLanguageDto().getId()));
        settingsDto.setPrintingDocumentsDto(printingDocumentsRepository.getById(settingsDto.getPrintingDocumentsDto().getId()));
        settingsDto.setStartScreenDto(startScreenRepository.getById(settingsDto.getStartScreenDto().getId()));
        settingsDto.setNotificationsDto(notificationsRepository.getById(settingsDto.getNotificationsDto().getId()));
        return settingsDto;
    }

    @Override
    public void create(SettingsDto settingsDto) {

        settingsRepository.save(ConverterDto.convertToModel(settingsDto));
    }

    @Override
    public void update(SettingsDto settingsDto) {
        settingsRepository.save(ConverterDto.convertToModel(settingsDto));
    }

    @Override
    public void deleteById(Long id) {
        settingsRepository.deleteById(id);
    }
}
