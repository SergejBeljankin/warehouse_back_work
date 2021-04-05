package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.ProductionOrderDto;
import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.repositories.ProductionOrderRepository;
import com.warehouse_accounting.repositories.TechnologicalMapRepository;
import com.warehouse_accounting.services.impl.ProductionOrderServiceImpl;
import com.warehouse_accounting.services.interfaces.ProductionOrderService;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductionOrderServiceTest {

    @Mock
    private ProductionOrderRepository productionOrderRepository;

    @InjectMocks
    private ProductionOrderServiceImpl productionOrderService;

    private ProductionOrderDto productionOrderDto = ProductionOrderDto.builder().id(1L).build();

    private final List<ProductionOrderDto> productionOrderDtoList = List.of(productionOrderDto);

    @Test
    void getAllTest() {
        when(productionOrderRepository.getAll()).thenReturn(productionOrderDtoList);
        List<ProductionOrderDto> productionOrderDtoListTest = productionOrderService.getAll();
        assertNotNull(productionOrderDtoListTest, "productionOrderDtoListTest = null");
        assertEquals(productionOrderDtoListTest, productionOrderDtoList);
        verify(productionOrderRepository, times(1)).getAll();
    }

    @Test
    void getByIdTest(){
        when(productionOrderRepository.getById(1L)).thenReturn(productionOrderDto);
        assertEquals(productionOrderService.getById(1L), productionOrderDto);
        verify(productionOrderRepository, times(1)).getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void createTest(){
        productionOrderService.create(productionOrderDto);
        verify(productionOrderRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(productionOrderDto)));
    }

    @Test
    void updateTest(){
        productionOrderService.update(productionOrderDto);
        verify(productionOrderRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(productionOrderDto)));
    }
    @Test
    void deleteTest(){
        productionOrderService.delete(1L);
        verify(productionOrderRepository, times(1))
                .deleteById(ArgumentMatchers.eq(1L));
    }
}
