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

    private CompanyRepository companyRepository;
    private ContractorRepository contractorRepository;
    private ContractRepository contractRepository;
    private EmployeeRepository employeeRepository;
    private InvoiceRepository invoiceRepository;
    private ProjectRepository projectRepository;
    private WarehouseRepository warehouseRepository;

    @Override
    public List<InvoiceDto> getAll() {return invoiceRepository.getAll();}

    @Override
    public InvoiceDto getById(Long id) {return invoiceRepository.getById(id);}

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
