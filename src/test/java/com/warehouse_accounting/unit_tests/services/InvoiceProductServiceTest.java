package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.*;
import com.warehouse_accounting.repositories.InvoiceProductRepository;
import com.warehouse_accounting.repositories.InvoiceRepository;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.services.impl.InvoiceProductServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class InvoiceProductServiceTest {
    @Mock
    private InvoiceProductRepository invoiceProductRepository;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private InvoiceProductServiceImpl invoiceProductService;

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

    private ProductDto productDto = ProductDto.builder()
            .id(1L)
            .name("Product")
            .weight(BigDecimal.valueOf(0))
            .volume(BigDecimal.valueOf(0))
            .purchasePrice(BigDecimal.valueOf(0))
            .description("Description")
            .unitDto(UnitDto.builder().build())
            .archive(false)
            .contractorDto(ContractorDto.builder().build())
            .productPricesDto(new ArrayList<>())
            .taxSystemDto(TaxSystemDto.builder().build())
            .imagesDto(new ArrayList<>())
            .productGroupDto(ProductGroupDto.builder().build())
            .attributeOfCalculationObjectDto(AttributeOfCalculationObjectDto.builder().build())
            .build();

    private final InvoiceProductDto invoiceProductDto = InvoiceProductDto.builder()
            .id(1L)
            .count(BigDecimal.valueOf(0))
            .price(BigDecimal.valueOf(0))
            .sum(BigDecimal.valueOf(0))
            .invoiceDto(invoiceDto)
            .productDto(productDto)
            .build();

    private final List <InvoiceProductDto> invoiceProductDtos = List.of(invoiceProductDto);

    @Test
    void test_create() {
        invoiceProductService.create(invoiceProductDto);
        verify(invoiceProductRepository, times(1))
                .save(ArgumentMatchers.eq((ConverterDto.convertToModel(invoiceProductDto))));
    }

    @Test
    void test_update() {
        invoiceProductService.update(invoiceProductDto);
        verify(invoiceProductRepository, times(1))
                .save(ArgumentMatchers.eq((ConverterDto.convertToModel(invoiceProductDto))));
    }

    @Test
    void test_delete() {
        invoiceProductService.deleteById(1L);
        verify(invoiceProductRepository, times(1)).deleteById(ArgumentMatchers.eq(1L));
    }

    @Test
    void test_getAll() {
        when(invoiceProductRepository.getAll()).thenReturn(invoiceProductDtos);
        when(invoiceRepository.getById(invoiceProductDto.getId())).thenReturn(invoiceDto);
        when(productRepository.getById(invoiceProductDto.getId())).thenReturn(productDto);
        List<InvoiceProductDto> invoiceProductDtoListInTest = invoiceProductService.getAll();
        assertNotNull(invoiceProductDtoListInTest, "invoiceProductDtoListInTest == null");
        assertEquals(invoiceProductDtoListInTest, invoiceProductDtos);
        assertEquals(invoiceRepository.getById(1L),invoiceDto);
        assertEquals(productRepository.getById(1L),productDto);
        verify(invoiceProductRepository, times(1)).getAll();
    }

    @Test
    void test_getById() {
        when(invoiceProductRepository.getById(1L)).thenReturn(invoiceProductDto);
        when(invoiceRepository.getById(invoiceProductDto.getId())).thenReturn(invoiceDto);
        when(productRepository.getById(invoiceProductDto.getId())).thenReturn(productDto);
        assertEquals(invoiceProductRepository.getById(1L), invoiceProductDto);
        assertEquals(invoiceRepository.getById(1L),invoiceDto);
        assertEquals(productRepository.getById(1L),productDto);
        verify(invoiceProductRepository, times(1)).getById(ArgumentMatchers.eq(1L));
    }
}
