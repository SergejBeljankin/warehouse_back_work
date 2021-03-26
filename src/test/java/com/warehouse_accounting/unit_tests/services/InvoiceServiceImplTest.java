package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.InvoiceDto;
import com.warehouse_accounting.repositories.InvoiceEditRepository;
import com.warehouse_accounting.repositories.InvoiceProductRepository;
import com.warehouse_accounting.repositories.InvoiceRepository;
import com.warehouse_accounting.services.impl.InvoiceServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class InvoiceServiceImplTest {
    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private InvoiceEditRepository invoiceEditRepository;

    @Mock
    private InvoiceProductRepository invoiceProductRepository;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    private InvoiceDto invoiceDto = InvoiceDto.builder()
            .id(1L)
            .number("number")
            .invoiceDateTime(LocalDateTime.of(2021, 1, 1, 0, 0, 0))
            .type("POSTING")
            .isPosted(false)
            .invoiceAuthorId(1L)
            .invoiceAuthorLastName("invoiceAuthorLastName")
            .invoiceAuthorFirstName("invoiceAuthorFirstName")
            .companyId(1L)
            .companyName("companyName")
            .projectId(1L)
            .projectName("projectName")
            .warehouseId(1L)
            .warehouseName("warehouseName")
            .comment("comment")
            .contractorId(1L)
            .contractorName("contractorName")
            .contractId(1L)
            .contractNumber("contractNumber")
            .contractDate(LocalDate.of(2021, 1, 1))
            .build();

    private final List<InvoiceDto> invoiceDtosList = List.of(invoiceDto);

    @Test
    void test_getAll() {
        when(invoiceRepository.getAll()).thenReturn(invoiceDtosList);
        when(invoiceProductRepository.getListInvoiceProductById(invoiceDto.getId())).thenReturn(new ArrayList<>());
        when(invoiceEditRepository.getListInvoiceEditById(invoiceDto.getId())).thenReturn(new ArrayList<>());
        List<InvoiceDto> invoiceDtoListInTest = invoiceService.getAll();
        assertNotNull(invoiceDtoListInTest, "invoiceDtoListInTest == null");
        assertEquals(invoiceDtoListInTest, invoiceDtosList);
        verify(invoiceRepository, times(1)).getAll();
    }

    @Test
    void test_getById() {
        when(invoiceRepository.getById(1L)).thenReturn(invoiceDto);
        when(invoiceProductRepository.getListInvoiceProductById(invoiceDto.getId())).thenReturn(new ArrayList<>());
        when(invoiceEditRepository.getListInvoiceEditById(invoiceDto.getId())).thenReturn(new ArrayList<>());
        assertEquals(invoiceRepository.getById(1L), invoiceDto);
        verify(invoiceRepository, times(1)).getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void test_create() {
        invoiceService.create(invoiceDto);
        verify(invoiceRepository, times(1))
                .save(ArgumentMatchers.eq((ConverterDto.convertToModel(invoiceDto))));
    }

    @Test
    void test_update() {
        invoiceService.update(invoiceDto);
        verify(invoiceRepository, times(1))
                .save(ArgumentMatchers.eq((ConverterDto.convertToModel(invoiceDto))));
    }

    @Test
    void test_delete() {
        invoiceService.deleteById(1L);
        verify(invoiceRepository, times(1)).deleteById(ArgumentMatchers.eq(1L));
    }
}
