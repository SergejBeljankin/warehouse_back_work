package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.ShipmentDto;
import com.warehouse_accounting.repositories.ProductRepository;
import com.warehouse_accounting.repositories.ShipmentRepository;
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
class ShipmentServiceImplTest {
    @Mock
    private ShipmentRepository shipmentRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ShipmentServiceImpl shipmentService;

    private static ShipmentDto shipmentDto;
    private static List<ShipmentDto> shipmentDtoList;
    @BeforeAll
    static void init() {
        ProductDto productDto = ProductDto.builder()
                .id(1L)
                .name("prod")
                .build();

        shipmentDto = ShipmentDto.builder()
                .id(1L)
                .dateOfCreation(LocalDateTime.now())
                .warehouseId(1L)
                .contractId(1L)
                .companyId(1L)
                .productDtos(List.of(productDto))
                .sum(BigDecimal.valueOf(111))
                .paid(BigDecimal.valueOf(111))
                .isSent(false)
                .isPrinted(true)
                .comment("first")
                .deliveryAddress("address")
                .carrierId(1L)
                .consigneeId(1L)
                .build();

        shipmentDtoList = List.of(shipmentDto);
    }
    @Test
    void getAll() {
        Mockito.when(shipmentRepository.getAll()).thenReturn(shipmentDtoList);
        List<ShipmentDto> result = shipmentService.getAll();

        assertEquals(result, shipmentDtoList);
        assertNotNull(result, "Null here");
        Mockito.verify(shipmentRepository, Mockito.times(1)).getAll();
    }

    @Test
    void getById() {
        Mockito.when(shipmentRepository.getById(1L)).thenReturn(shipmentDto);
        assertEquals(shipmentService.getById(1L), shipmentDto);
        Mockito.verify(shipmentRepository, Mockito.times(1)).getById(1L);
    }

    @Test
    void create() {
        shipmentService.create(shipmentDto);
        Mockito.verify(shipmentRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(shipmentDto)));
    }

    @Test
    void update() {
        shipmentService.create(shipmentDto);
        Mockito.verify(shipmentRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(shipmentDto)));
    }

    @Test
    void deleteById() {
        shipmentService.deleteById(2L);
        Mockito.verify(shipmentRepository, Mockito.times(1))
                .deleteById(ArgumentMatchers.eq(2L));
    }
}