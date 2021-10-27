package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.SupplyDto;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.repositories.SupplyRepository;
import com.warehouse_accounting.services.impl.SupplyServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SupplyServiceImplTest {

    @Mock
    private SupplyRepository supplyRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private SupplyServiceImpl supplyService;

    private static SupplyDto supplyDto1;
    private static SupplyDto supplyDto2;
    private static List<SupplyDto> supplyDtoList;

    @BeforeAll
    static void init() {
        ProductDto productDto = ProductDto.builder()
                .id(1L)
                .name("prod")
                .build();

        supplyDto1 = SupplyDto.builder()
                .id(1L)
                .dateOfCreation(LocalDateTime.now())
                .warehouseId(1L)
                .contractId(1L)
                .companyId(1L)
                .productDtos(List.of(productDto))
                .sum(BigDecimal.valueOf(100))
                .paid(BigDecimal.valueOf(10))
                .isSent(false)
                .isPrinted(true)
                .comment("first")
                .build();
        supplyDto2 = SupplyDto.builder()
                .id(21L)
                .dateOfCreation(LocalDateTime.now())
                .warehouseId(2L)
                .contractId(2L)
                .companyId(2L)
                .productDtos(List.of(productDto))
                .sum(BigDecimal.valueOf(200))
                .paid(BigDecimal.valueOf(20))
                .isSent(false)
                .isPrinted(true)
                .comment("second")
                .build();
        supplyDtoList = List.of(supplyDto1, supplyDto2);
    }

    @Test
    void getAll() {

        Mockito.when(supplyRepository.getAll()).thenReturn(supplyDtoList);
        List<SupplyDto> result = supplyService.getAll();

        assertEquals(result, supplyDtoList);
        assertNotNull(result, "Null here");
        Mockito.verify(supplyRepository, Mockito.times(1)).getAll();

    }

    @Test
    void getById() {
        Mockito.when(supplyRepository.getById(1L)).thenReturn(supplyDto1);
        Mockito.when(supplyRepository.getById(2L)).thenReturn(supplyDto2);
        assertNotEquals(supplyService.getById(1L), supplyDto2);
        assertEquals(supplyService.getById(2L), supplyDto2);
        Mockito.verify(supplyRepository, Mockito.times(1)).getById(1L);
    }

    @Test
    void create() {
        supplyService.create(supplyDto1);
        Mockito.verify(supplyRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(supplyDto1)));
    }

    @Test
    void update() {
        supplyService.create(supplyDto1);
        Mockito.verify(supplyRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(supplyDto1)));
    }

    @Test
    void deleteById() {
        supplyService.deleteById(22L);
        Mockito.verify(supplyRepository, Mockito.times(1))
                .deleteById(ArgumentMatchers.eq(22L));
    }
}