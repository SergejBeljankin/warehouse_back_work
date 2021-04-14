package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.CallDto;
import com.warehouse_accounting.repositories.CallRepository;
import com.warehouse_accounting.services.impl.CallServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
 class CallServiceImplTest {

    @Mock
    private CallRepository callRepository;

    @InjectMocks
    private CallServiceImpl callService;

    private static CallDto callDto;
    private static List<CallDto> callDtoList;

    @BeforeAll
    static void initCallDto() {
        callDto = CallDto.builder()
                .id(1L)
                .build();
        callDtoList = List.of(callDto);
    }

    @Test
     void getAll() {
        when(callRepository.getAll()).thenReturn(callDtoList);
        List<CallDto> callDtoListTest = callService.getAll();
        assertNotNull(callDtoListTest,"callDtoList is not null");
        assertEquals(callDtoList, callDtoListTest);
        verify(callRepository, times(1)).getAll();
    }

    @Test
    void testGetById(){
        when(callRepository.getById(1L)).thenReturn(callDto);
        CallDto callDtoTest = callService.getById(1L);
        assertNotNull(callDtoTest,"callDto is not null");
        assertEquals(callDtoTest,callDto);
        verify(callRepository,times(1)).getById(1L);
    }

    @Test
    void testCreate(){
        callService.create(callDto);
        verify(callRepository,times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(callDto)));
    }

    @Test
    void testUpdate(){
        callService.update(callDto);
        verify(callRepository,times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(callDto)));
    }

    @Test
    void testDelete(){
        callService.deleteById(1L);
        verify(callRepository,times(1)).deleteById(1L);
    }
}

