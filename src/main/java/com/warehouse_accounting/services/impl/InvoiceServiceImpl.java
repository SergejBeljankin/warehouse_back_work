package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.InvoiceDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.InvoiceEditRepository;
import com.warehouse_accounting.repositories.InvoiceProductRepository;
import com.warehouse_accounting.repositories.InvoiceRepository;
import com.warehouse_accounting.repositories.ProjectRepository;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.InvoiceService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final CompanyRepository companyRepository;
    private final ContractorRepository contractorRepository;
    private final ContractRepository contractRepository;
    private final EmployeeRepository employeeRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceEditRepository invoiceEditRepository;
    private final InvoiceProductRepository invoiceProductRepository;
    private final ProjectRepository projectRepository;
    private final WarehouseRepository warehouseRepository;

    public InvoiceServiceImpl(CompanyRepository companyRepository,
                              ContractorRepository contractorRepository,
                              ContractRepository contractRepository,
                              EmployeeRepository employeeRepository,
                              InvoiceRepository invoiceRepository,
                              InvoiceEditRepository invoiceEditRepository,
                              InvoiceProductRepository invoiceProductRepository,
                              ProjectRepository projectRepository,
                              WarehouseRepository warehouseRepository) {
        this.companyRepository = companyRepository;
        this.contractorRepository = contractorRepository;
        this.contractRepository = contractRepository;
        this.employeeRepository = employeeRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceEditRepository = invoiceEditRepository;
        this.invoiceProductRepository = invoiceProductRepository;
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
            invoiceDto.setProductDtos(invoiceProductRepository.getListInvoiceProductById(invoiceDto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
            invoiceDto.setContractorDto(contractorRepository.getById(invoiceDto.getContractorDto().getId()));
            invoiceDto.setContractDto(contractRepository.getById(invoiceDto.getContractDto().getId()));
            invoiceDto.setEdits(invoiceEditRepository.getListInvoiceEditById(invoiceDto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
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
        invoiceDto.setProductDtos(invoiceProductRepository.getListInvoiceProductById(invoiceDto.getId())
                .stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList()));
        invoiceDto.setContractorDto(contractorRepository.getById(invoiceDto.getContractorDto().getId()));
        invoiceDto.setContractDto(contractRepository.getById(invoiceDto.getContractDto().getId()));
        invoiceDto.setEdits(invoiceEditRepository.getListInvoiceEditById(invoiceDto.getId())
                .stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList()));
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
