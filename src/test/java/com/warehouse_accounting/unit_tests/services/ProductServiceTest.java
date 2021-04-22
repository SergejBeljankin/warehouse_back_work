package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.ProductGroupDto;
import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.repositories.AttributeOfCalculationObjectRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.ImageRepository;
import com.warehouse_accounting.repositories.ProductGroupRepository;
import com.warehouse_accounting.repositories.ProductPriceRepository;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.repositories.TaxSystemRepository;
import com.warehouse_accounting.repositories.UnitRepository;
import com.warehouse_accounting.services.impl.ProductServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private UnitRepository unitRepository;
    @Mock
    private ContractorRepository contractorRepository;
    @Mock
    private ProductPriceRepository productPriceRepository;
    @Mock
    private TaxSystemRepository taxSystemRepository;
    @Mock
    private ImageRepository imageRepository;
    @Mock
    private ProductGroupRepository productGroupRepository;
    @Mock
    private AttributeOfCalculationObjectRepository attributeOfCalculationObjectRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private static ProductDto productDto;
    private static List<ProductDto> productDtoList;

    @BeforeAll
    static void initMethod() {
        productDto = ProductDto.builder()
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

        productDtoList = List.of(productDto);
    }

    @Test
    void test_getAll() {
        when(productRepository.getAll()).thenReturn(productDtoList);
        List<ProductDto> productDtoListInTest = productService.getAll();
        assertNotNull(productDtoListInTest, "productDtoListInTest == null");
        assertEquals(productDtoListInTest, productDtoList);
        verify(productRepository, times(1)).getAll();
    }

    @Test
    void test_getById() {
        when(productRepository.getById(1L)).thenReturn(productDto);
        assertEquals(productRepository.getById(1L), productDto);
        verify(productRepository, times(1)).getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void test_create() {
        productService.create(productDto);
        verify(productRepository, times(1))
                .save(ArgumentMatchers.eq((ConverterDto.convertToModel(productDto))));
    }

    @Test
    void test_update() {
        productService.create(productDto);
        verify(productRepository, times(1))
                .save(ArgumentMatchers.eq((ConverterDto.convertToModel(productDto))));
    }

    @Test
    void test_deleteById() {
        productService.deleteById(1L);
        verify(productRepository, times(1)).deleteById(ArgumentMatchers.eq(1L));
    }

}