package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.AdjustmentDto;
import com.warehouse_accounting.repositories.AdjustmentRepository;
import com.warehouse_accounting.services.impl.AdjustmentServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AdjustmentServiceImplTest {

    @Mock
    private AdjustmentRepository adjustmentRepository;

    @InjectMocks
    private AdjustmentServiceImpl adjustmentService;

    private static AdjustmentDto adjustmentDto;
    private static List<AdjustmentDto> adjustmentDtoList;

    @BeforeAll
    static void initAdjustmentDto() {
        adjustmentDto = AdjustmentDto.builder()
                .id(1L)
                .build();
        adjustmentDtoList = List.of(adjustmentDto);
    }

    @Test
    void getAll() {
        when(adjustmentRepository.getAll()).thenReturn(adjustmentDtoList);
        List<AdjustmentDto> adjustmentDtoListTest = adjustmentService.getAll();
        assertNotNull(adjustmentDtoListTest, "adjustmentDtoList is not null");
        assertEquals(adjustmentDtoList, adjustmentDtoListTest);
        verify(adjustmentRepository, times(1)).getAll();
    }

    @Test
    void testGetById() {
        when(adjustmentRepository.getById(1L)).thenReturn(adjustmentDto);
        AdjustmentDto adjustmentDtoTest = adjustmentService.getById(1L);
        Assertions.assertNotNull(adjustmentDtoTest, "adjustmentDto is not null");
        assertEquals(adjustmentDtoTest, adjustmentDto);
        verify(adjustmentRepository, times(1)).getById(1L);
    }

    @Test
    void testCreate() {
        adjustmentService.create(adjustmentDto);
        verify(adjustmentRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(adjustmentDto)));
    }

    @Test
    void testUpdate() {
        adjustmentService.update(adjustmentDto);
        verify(adjustmentRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(adjustmentDto)));
    }

    @Test
    void testDelete() {
        adjustmentService.deleteById(1L);
        verify(adjustmentRepository, times(1)).deleteById(1L);
    }
}
