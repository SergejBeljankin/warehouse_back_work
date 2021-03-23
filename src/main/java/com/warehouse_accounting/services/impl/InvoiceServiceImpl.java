package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.InvoiceDto;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.InvoiceEditRepository;
import com.warehouse_accounting.repositories.InvoiceProductRepository;
import com.warehouse_accounting.repositories.InvoiceRepository;
import com.warehouse_accounting.services.interfaces.InvoiceService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceEditRepository invoiceEditRepository;
    private final InvoiceProductRepository invoiceProductRepository;


    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              InvoiceEditRepository invoiceEditRepository,
                              InvoiceProductRepository invoiceProductRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceEditRepository = invoiceEditRepository;
        this.invoiceProductRepository = invoiceProductRepository;
    }

    @Override
    public List<InvoiceDto> getAll() {
        List<InvoiceDto> invoiceDtos = invoiceRepository.getAll();
        for (InvoiceDto invoiceDto : invoiceDtos) {
            invoiceDto.setProductDtos(invoiceProductRepository.getListInvoiceProductById(invoiceDto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
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
        invoiceDto.setProductDtos(invoiceProductRepository.getListInvoiceProductById(invoiceDto.getId())
                .stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList()));
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
