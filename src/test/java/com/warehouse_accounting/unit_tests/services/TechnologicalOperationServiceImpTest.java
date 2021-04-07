package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.repositories.TechnologicalOperationRepository;
import com.warehouse_accounting.services.impl.TechnologicalOperationServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
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
class TechnologicalOperationServiceImpTest {

    @Mock
    private TechnologicalOperationRepository technologicalOperationRepository;

    @InjectMocks
    private TechnologicalOperationServiceImpl technologicalOperationService;

    private static TechnologicalOperationDto technologicalOperationDto;
    private static List<TechnologicalOperationDto> technologicalOperationDtoList;

    @BeforeAll
    static void init() {

        technologicalOperationDto = TechnologicalOperationDto.builder()
                .id(1L)
                .build();

        technologicalOperationDtoList = List.of(technologicalOperationDto);
    }

    @Test
    void testGetAll() {
        when(technologicalOperationRepository.getAll()).thenReturn(technologicalOperationDtoList);
        List<TechnologicalOperationDto> technologicalOperationDtoListTest = technologicalOperationService.getAll();
        assertNotNull(technologicalOperationDtoListTest, "technologicalOperationDtoListTest is null");
        assertEquals(technologicalOperationDtoList ,technologicalOperationDtoListTest);
        verify(technologicalOperationRepository, times(1)).getAll();
    }

    @Test
    void testGetById() {
        when(technologicalOperationRepository.getById(1L)).thenReturn(technologicalOperationDto);
        TechnologicalOperationDto technologicalOperationDtoTest = technologicalOperationService.getById(1L);
        assertNotNull(technologicalOperationDtoTest, "technologicalOperationDtoTest is null");
        assertEquals(technologicalOperationDtoTest, technologicalOperationDto);
        verify(technologicalOperationRepository, times(1)).getById(1L);
    }

    @Test
    void testCreate() {
        technologicalOperationService.create(technologicalOperationDto);
        verify(technologicalOperationRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(technologicalOperationDto)));
    }

    @Test
    void testUpdate() {
        technologicalOperationService.update(technologicalOperationDto);
        verify(technologicalOperationRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(technologicalOperationDto)));
    }

    @Test
    void testDelete() {
        technologicalOperationService.deleteById(1L);
        verify(technologicalOperationRepository, times(1)).deleteById(1L);
    }
}
