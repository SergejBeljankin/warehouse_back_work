package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.repositories.TechnologicalMapRepository;
import com.warehouse_accounting.repositories.TechnologicalOperationRepository;
import com.warehouse_accounting.services.impl.TechnologicalMapServiceImpl;
import com.warehouse_accounting.services.impl.TechnologicalOperationServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class TechnologicalOperationServiceImpTest {

    @Mock
    private TechnologicalOperationRepository technologicalOperationRepository;
    @Mock
    private TechnologicalMapRepository technologicalMapRepository;

    @InjectMocks
    private TechnologicalOperationServiceImpl technologicalOperationService;
    @InjectMocks
    private TechnologicalMapServiceImpl technologicalMapService;

    private static TechnologicalMapDto technologicalMapDto;
    private static TechnologicalOperationDto technologicalOperationDto;
    private static List<TechnologicalOperationDto> technologicalOperationDtoList;

    @BeforeAll
    static void init() {
        technologicalMapDto = TechnologicalMapDto.builder()
                .id(1L)
                .name("technologicalMapDto")
                .comment("comment")
                .isArchived(false)
                .productionCost(BigDecimal.valueOf(11.11))
                .technologicalMapGroupId(1L)
                .technologicalMapGroupName("technologicalMapGroupName")
                .build();

        technologicalOperationDto = TechnologicalOperationDto.builder()
                .id(1L)
                .number("tex.Operation")
                .isArchive(false)
                .technologicalOperationDateTime(LocalDateTime.of(2021, 1, 1, 1, 1, 1))
                .comments("comments")
                .warehouseForMaterialsId(1L)
                .warehouseForMaterialsName("warehouseForMaterialsName")
                .warehouseForProductId(2L)
                .warehouseForProductName("warehouseForProductName")
                .companyId(1L)
                .companyName("company")
                .projectId(1L)
                .projectName("project")
                .technologicalMapDtoObj(technologicalMapDto)
                .volumeOfProduction(BigDecimal.valueOf(12.1))
                .build();

        technologicalOperationDtoList = List.of(technologicalOperationDto);
    }
//    private final TechnologicalMapDto technologicalMapDto = TechnologicalMapDto.builder()
//            .id(1L)
//            .name("technologicalMapDto")
//            .comment("comment")
//            .isArchived(false)
//            .productionCost(BigDecimal.valueOf(11.11))
//            .technologicalMapGroupId(1L)
//            .technologicalMapGroupName("technologicalMapGroupName")
//            .build();
//
//    private final TechnologicalOperationDto technologicalOperationDto = TechnologicalOperationDto.builder()
//            .id(1L)
//            .number("tex.Operation")
//            .isArchive(false)
//            .technologicalOperationDateTime(LocalDateTime.of(2021,1,1,1,1,1))
//            .comments("comments")
//            .warehouseForMaterialsId(1L)
//            .warehouseForMaterialsName("warehouseForMaterialsName")
//            .warehouseForProductId(2L)
//            .warehouseForProductName("warehouseForProductName")
//            .companyId(1L)
//            .companyName("company")
//            .projectId(1L)
//            .projectName("project")
//            .technologicalMapDtoObj(technologicalMapDto)
//            .build();
//
//    private final List<TechnologicalOperationDto> technologicalOperationDtoList = List.of(technologicalOperationDto);

    @Test
    void testGetAll() {
        when(technologicalOperationRepository.getAll()).thenReturn(technologicalOperationDtoList);
        technologicalOperationDto.setTechnologicalMapDtoObj(technologicalMapDto);
        List<TechnologicalOperationDto> technologicalOperationDtoListTest = technologicalOperationService.getAll();
        assertNotNull(technologicalOperationDtoListTest, "technologicalOperationDtoListTest is null");
        assertEquals(technologicalOperationDtoListTest, technologicalOperationDtoList);
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
        technologicalMapService.create(technologicalMapDto);
        verify(technologicalMapRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(technologicalMapDto)));
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
