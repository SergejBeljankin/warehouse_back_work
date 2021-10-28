package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.CustomerReturnsDto;
import com.warehouse_accounting.models.dto.WarehouseDto;
import com.warehouse_accounting.repositories.CustomerReturnsRepository;
import com.warehouse_accounting.services.impl.CustomerReturnsServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CustomerReturnsServiceTest {
    @Mock
    private CustomerReturnsRepository customerReturnsRepository;

    @InjectMocks
    private CustomerReturnsServiceImpl customerReturnsService;

    private static CustomerReturnsDto customerReturnsDto;

    private static List<CustomerReturnsDto> customerReturnsDtoList = new ArrayList<>();

    @BeforeAll
    static void init() {
        CustomerReturnsDto.builder()
                .id(1L)
                .date(LocalDateTime.now())
                .warehouseDto(WarehouseDto.builder().build())
                .contractDto(ContractDto.builder().build())
                .contractorDto(ContractorDto.builder().build())
                .companyDto(CompanyDto.builder().build())
                .productDtos(new ArrayList<>())
                .taskDtos(new ArrayList<>())
                .fileDtos(new ArrayList<>())
                .sum(BigDecimal.valueOf(10000))
                .isPaid(true)
                .isSend(false)
                .comment("Возврат оформлен")
                .build();

        customerReturnsDtoList.add(customerReturnsDto);
    }


    @Test
    void getAll() {
        when(customerReturnsRepository.getAll()).thenReturn(customerReturnsDtoList);
        List<CustomerReturnsDto> customerReturnsDtoListTest = customerReturnsService.getAll();
        assertNotNull(customerReturnsDtoListTest, "customerReturnsDtoListTest == null");
        assertEquals(customerReturnsDtoListTest, customerReturnsDtoList);
        verify(customerReturnsRepository, times(1)).getAll();
    }

    @Test
    void getById() {
        when(customerReturnsRepository.getById(1l)).thenReturn(customerReturnsDto);
        assertEquals(customerReturnsRepository.getById(1l),customerReturnsDto);
        verify(customerReturnsRepository, times(1)).getById(ArgumentMatchers.eq(1l));
    }

    @Test
    void create() {
        customerReturnsService.create(customerReturnsDto);
        verify(customerReturnsRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(customerReturnsDto)));
    }

    @Test
    void update() {
        customerReturnsService.update(customerReturnsDto);
        verify(customerReturnsRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(customerReturnsDto)));
    }

    @Test
    void deleteById() {
        customerReturnsService.deleteById(1l);
        verify(customerReturnsRepository, times(1)).deleteById(ArgumentMatchers.eq(1l));
    }
}
