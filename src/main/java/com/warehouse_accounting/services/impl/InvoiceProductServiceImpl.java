package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.InvoiceProductDto;
import com.warehouse_accounting.repositories.InvoiceProductRepository;
import com.warehouse_accounting.repositories.InvoiceRepository;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class InvoiceProductServiceImpl implements com.warehouse_accounting.services.interfaces.InvoiceProductService {
    private final InvoiceProductRepository invoiceProductRepository;
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;

    public InvoiceProductServiceImpl(InvoiceProductRepository invoiceProductRepository, InvoiceRepository invoiceRepository, ProductRepository productRepository) {
        this.invoiceProductRepository = invoiceProductRepository;
        this.invoiceRepository = invoiceRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<InvoiceProductDto> getAll() {
        List<InvoiceProductDto> invoiceProductDtos = invoiceProductRepository.getAll();
        for (InvoiceProductDto invoiceProductDto:invoiceProductDtos) {
            invoiceProductDto.setInvoiceDto(invoiceRepository.getById(invoiceProductDto.getInvoiceDto().getId()));
            invoiceProductDto.setProductDto(productRepository.getById(invoiceProductDto.getProductDto().getId()));
        }
        return invoiceProductDtos;
    }

    @Override
    public InvoiceProductDto getById(Long id) {
        InvoiceProductDto invoiceProductDto = invoiceProductRepository.getById(id);
        invoiceProductDto.setInvoiceDto(invoiceRepository.getById(invoiceProductDto.getInvoiceDto().getId()));
        invoiceProductDto.setProductDto(productRepository.getById(invoiceProductDto.getProductDto().getId()));
        return invoiceProductDto;
    }

    @Override
    public void create(InvoiceProductDto invoiceProductDto) {
        invoiceProductRepository.save(ConverterDto.convertToModel(invoiceProductDto));
    }

    @Override
    public void update(InvoiceProductDto invoiceProductDto) {
        invoiceProductRepository.save(ConverterDto.convertToModel(invoiceProductDto));
    }

    @Override
    public void deleteById(Long id) {
        invoiceProductRepository.deleteById(id);
    }
}
