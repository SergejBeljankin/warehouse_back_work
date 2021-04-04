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

    @Mock
    private TechnologicalMapRepository technologicalMapRepository;

    @InjectMocks
    private ProductionOrderServiceImpl productionOrderService;

    private TechnologicalMapDto technologicalMapDto = TechnologicalMapDto.builder()
            .id(1L)
            .name("name1")
            .isArchived(true)
            .productionCost(new BigDecimal(500))
            .technologicalMapGroupId(2L)
            .technologicalMapGroupName("techMapGroupName")
            .build();


    private ProductionOrderDto productionOrderDto = ProductionOrderDto.builder()
            .id(1L)
            .number("number")
            .dateTime(LocalDateTime.of(2021, 1, 1, 0, 0, 0))
            .companyId(1L)
            .companyName("companyName")
            .techMapDto(technologicalMapDto)
            .volumeOfProduction(new BigDecimal(100))
            .warehouseId(1L)
            .warehouseName("warehouseName")
            .planDate(LocalDate.of(2021, 1, 1))
            .projectId(1L)
            .projectName("projectName")
            .comment("comment")
            .build();
    private final List<ProductionOrderDto> productionOrderDtoList = List.of(productionOrderDto);

    @Test
    void getAllTest() {
        when(productionOrderRepository.getAll()).thenReturn(productionOrderDtoList);
        when(technologicalMapRepository.getById(productionOrderDto.getTechMapDto().getId()))
                .thenReturn(productionOrderDto.getTechMapDto());
        List<ProductionOrderDto> productionOrderDtoListTest = productionOrderService.getAll();
        assertNotNull(productionOrderDtoListTest, "productionOrderDtoListTest = null");
        assertEquals(productionOrderDtoListTest, productionOrderDtoList);
        verify(productionOrderRepository, times(1)).getAll();
    }

    @Test
    void getByIdTest(){
        when(productionOrderRepository.getById(1L)).thenReturn(productionOrderDto);
        when(technologicalMapRepository.getById(productionOrderDto.getTechMapDto().getId()))
                .thenReturn(productionOrderDto.getTechMapDto());
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
