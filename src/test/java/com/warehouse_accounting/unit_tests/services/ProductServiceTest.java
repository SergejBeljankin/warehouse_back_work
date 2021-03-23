package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.ProductGroupDto;
import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.services.impl.ProductServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceTest {

    private static ProductDto productDto1;

    private static ProductDto productDto2;

    private static List<ProductDto> productDtoList;

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeAll
    static void fillingProductDto(){
        productDto1 = ProductDto.builder()
                .id(1L)
                .name("first")
                .weight(BigDecimal.ONE)
                .volume(BigDecimal.ONE)
                .purchasePrice(BigDecimal.ONE)
                .description("first")
                .unitDto( new UnitDto())
                .contractorDto(new ContractorDto())
                .productPricesDto(new ArrayList<>())
                .taxSystemDto(new TaxSystemDto())
                .imagesDto(new ArrayList<>())
                .productGroupDto(new ProductGroupDto())
                .attributeOfCalculationObjectDto(new AttributeOfCalculationObjectDto())
                .build();
        productDto2 = ProductDto.builder()
                .id(2L)
                .name("second")
                .weight(BigDecimal.TEN)
                .volume(BigDecimal.TEN)
                .purchasePrice(BigDecimal.TEN)
                .description("second")
                .unitDto( new UnitDto())
                .contractorDto(new ContractorDto())
                .productPricesDto(new ArrayList<>())
                .taxSystemDto(new TaxSystemDto())
                .imagesDto(new ArrayList<>())
                .productGroupDto(new ProductGroupDto())
                .attributeOfCalculationObjectDto(new AttributeOfCalculationObjectDto())
                .build();
        productDtoList = List.of(productDto1, productDto2);
    }

    @Test
    void getAll(){
        when(productRepository.getAll()).thenReturn(productDtoList);
        List<ProductDto> resultProductDtoList = productRepository.getAll();
        Assert.notNull(resultProductDtoList, "return null");
        Assertions.assertEquals(productDtoList, resultProductDtoList);
        Mockito.verify(productRepository, Mockito.times(1))
                .getAll();
    }

    @Test
    void getById(){
        when(productRepository.getById(1L)).thenReturn(productDto1);
        Assertions.assertEquals(productRepository.getById(1L), productDto1);
        verify(productRepository, times(1))
                .getById(1l);
    }

    @Test
    void create(){
        productService.create(productDto1);
        verify(productRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(productDto1)));
    }

    @Test
    void update(){
        productService.update(productDto2);
        verify(productRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(productDto2)));
    }

    @Test
    void deleteById(){
        productService.deleteById(1L);
        verify(productRepository, times(1))
                .deleteById(ArgumentMatchers.eq(1L));
        productService.deleteById(2L);
        verify(productRepository, times(1))
                .deleteById(ArgumentMatchers.eq(2L));
    }
}
