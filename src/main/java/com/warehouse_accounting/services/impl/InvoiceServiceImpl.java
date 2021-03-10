package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.InvoiceDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.InvoiceRepository;
import com.warehouse_accounting.repositories.ProjectRepository;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.InvoiceService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final CompanyRepository companyRepository;
    private final ContractorRepository contractorRepository;
    private final ContractRepository contractRepository;
    private final EmployeeRepository employeeRepository;
    private final InvoiceRepository invoiceRepository;
    private final ProjectRepository projectRepository;
    private final WarehouseRepository warehouseRepository;

    public InvoiceServiceImpl(CompanyRepository companyRepository,
                              ContractorRepository contractorRepository,
                              ContractRepository contractRepository,
                              EmployeeRepository employeeRepository,
                              InvoiceRepository invoiceRepository,
                              ProjectRepository projectRepository,
                              WarehouseRepository warehouseRepository) {
        this.companyRepository = companyRepository;
        this.contractorRepository = contractorRepository;
        this.contractRepository = contractRepository;
        this.employeeRepository = employeeRepository;
        this.invoiceRepository = invoiceRepository;
        this.projectRepository = projectRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<InvoiceDto> getAll() {
        List<InvoiceDto> invoiceDtos = invoiceRepository.getAll();
        for (InvoiceDto invoiceDto : invoiceDtos) {
            invoiceDto.setInvoiceAuthor(employeeRepository.getById(invoiceDto.getInvoiceAuthor().getId()));
            invoiceDto.setCompanyDto(companyRepository.getById(invoiceDto.getCompanyDto().getId()));
            invoiceDto.setProjectDto(projectRepository.getById(invoiceDto.getProjectDto().getId()));
            invoiceDto.setWarehouseDto(warehouseRepository.getById(invoiceDto.getWarehouseDto().getId()));
            invoiceDto.setContractorDto(contractorRepository.getById(invoiceDto.getContractorDto().getId()));
            invoiceDto.setContractDto(contractRepository.getById(invoiceDto.getContractDto().getId()));
        }
        return invoiceDtos;
    }

    @Override
    public InvoiceDto getById(Long id) {
        InvoiceDto invoiceDto = invoiceRepository.getById(id);
        invoiceDto.setInvoiceAuthor(employeeRepository.getById(invoiceDto.getInvoiceAuthor().getId()));
        invoiceDto.setCompanyDto(companyRepository.getById(invoiceDto.getCompanyDto().getId()));
        invoiceDto.setProjectDto(projectRepository.getById(invoiceDto.getProjectDto().getId()));
        invoiceDto.setWarehouseDto(warehouseRepository.getById(invoiceDto.getWarehouseDto().getId()));
        invoiceDto.setContractorDto(contractorRepository.getById(invoiceDto.getContractorDto().getId()));
        invoiceDto.setContractDto(contractRepository.getById(invoiceDto.getContractDto().getId()));
        return invoiceDto;
    }

    @Override
    public void create(InvoiceDto invoiceDto) {
        invoiceRepository.save(ConverterDto.convertToModel(invoiceDto));
    }

    @Override
    public void update(InvoiceDto invoiceDto) {
        invoiceRepository.save(ConverterDto.convertToModel(invoiceDto));
    }

    @Override
    public void deleteById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
