package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.InvoiceEditDto;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.InvoiceEditRepository;
import com.warehouse_accounting.services.interfaces.InvoiceEditService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceEditServiceImpl implements InvoiceEditService {

    private final InvoiceEditRepository invoiceEditRepository;
    private final EmployeeRepository employeeRepository;

    public InvoiceEditServiceImpl(EmployeeRepository employeeRepository,
                                  InvoiceEditRepository invoiceEditRepository) {
        this.employeeRepository = employeeRepository;
        this.invoiceEditRepository = invoiceEditRepository;
    }


    @Override
    public List<InvoiceEditDto> getAll() {
        List<InvoiceEditDto> invoiceEdits = invoiceEditRepository.getAll();
        for (InvoiceEditDto edit : invoiceEdits) {
            edit.setEditAuthorDto(employeeRepository.getById(edit.getEditAuthorDto().getId()));
        }
        return invoiceEdits;
    }

    @Override
    public InvoiceEditDto getById(Long id) {
        InvoiceEditDto edit = invoiceEditRepository.getById(id);
        edit.setEditAuthorDto(employeeRepository.getById(edit.getEditAuthorDto().getId()));
        return edit;
    }

    @Override
    public void create(InvoiceEditDto invoiceEditDto) {
        invoiceEditRepository.save(ConverterDto.convertToModel(invoiceEditDto));
    }

    @Override
    public void update(InvoiceEditDto invoiceEditDto) {
        invoiceEditRepository.save(ConverterDto.convertToModel(invoiceEditDto));
    }

    @Override
    public void deleteById(Long id) {
        invoiceEditRepository.deleteById(id);
    }
}
