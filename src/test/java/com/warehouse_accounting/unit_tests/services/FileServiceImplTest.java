package com.warehouse_accounting.unit_tests.services;


import com.warehouse_accounting.models.Employee;
import com.warehouse_accounting.models.dto.FileDto;
import com.warehouse_accounting.repositories.FileRepository;
import com.warehouse_accounting.services.impl.FileServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FileServiceImplTest {

    @Mock
    private FileRepository fileRepository;

    @InjectMocks
    private FileServiceImpl fileService;

    private static FileDto fileDto;

    private static List<FileDto> fileDtoList = new ArrayList<>();

    @BeforeAll
    static void init() {

        Date date = new Date();
        Employee employee = new Employee();


                fileDto = FileDto.builder()
                .id(1L)
                .name("Покупки")
                .size(10)
                .location("Москва")
                .createdDate(date)
                .employee(new ArrayList<>())
                .build();

    }

    @Test
    void getAll() {

        when(fileRepository.findAll().stream()
                .map(ConverterDto::convertToDto
                ).collect(Collectors.toList())).thenReturn(fileDtoList);

        List<FileDto> fileDtoListTest = fileRepository.findAll().stream()
                .map(ConverterDto::convertToDto
                ).collect(Collectors.toList());

        assertNotNull(fileDtoListTest, "fileDtoListTest == null");
        assertEquals(fileDtoListTest, fileDtoList);
        verify(fileRepository, times(1)).findAll();

    }

    @Test
    void getById() {
        when(fileRepository.findById(1L)).thenReturn(Optional.of(ConverterDto.convertToModel(fileDto)));

        assertEquals(fileRepository.findById(1L), Optional.of(ConverterDto.convertToModel(fileDto)));

        verify(fileRepository, times(1)).findById(ArgumentMatchers.eq(1L));
    }

    @Test
    void create() {
        fileRepository.save(ConverterDto.convertToModel(fileDto));

        verify(fileRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(fileDto)));
    }

    @Test
    void update() {
        fileService.update(fileDto);

        verify(fileRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(fileDto)));
    }

    @Test
    void deleteById() {
        fileService.delete(1L);
        verify(fileRepository, times(1))
                .deleteById(ArgumentMatchers.eq(1L));
    }

}
