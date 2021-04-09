package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.CountryDto;
import com.warehouse_accounting.repositories.CountryRepository;
import com.warehouse_accounting.services.impl.CountryServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class CountryServiceImplTest {

    @InjectMocks
    private CountryServiceImpl countryService;

    @Mock
    private CountryRepository countryRepository;


    private final CountryDto countryDto = CountryDto.builder()
            .id((long) 1)
            .shortName("Россия")
            .longName("Российская Федерация")
            .code(BigInteger.valueOf(632))
            .codeOne("RU")
            .codeTwo("RUS")
            .build();
    private final List<CountryDto> countryDtoList = List.of(countryDto);


    @Test
    void getAll() {
        when(countryRepository.getAll()).thenReturn(countryDtoList);
        List<CountryDto> countryDtoListTest = countryService.getAll();
        assertNotNull(countryDtoListTest, "countryDtoListTest = null");
        assertEquals(countryDtoListTest, countryDtoList);
        verify(countryRepository , times(1)).getAll();
    }

    @Test
    void getById() {
        when(countryRepository.getById(1L)).thenReturn(countryDto);
        assertEquals(countryService.getById(1L), countryDto);
        verify(countryRepository , times(1)).getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void create() {
        countryService.create(countryDto);
        verify(countryRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(countryDto)));
    }

    @Test
    void update() {
        countryService.update(countryDto);
        verify(countryRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(countryDto)));
    }

    @Test
    void deleteById() {
        countryService.deleteById(1L);
        verify(countryRepository, times(1))
                .deleteById(ArgumentMatchers.eq(1L));
    }
}