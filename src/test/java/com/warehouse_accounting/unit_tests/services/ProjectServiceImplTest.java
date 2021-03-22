package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.ProjectDto;
import com.warehouse_accounting.repositories.ProjectRepository;
import com.warehouse_accounting.services.impl.ProjectServiceImpl;
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
class ProjectServiceImplTest {


    @InjectMocks
    private ProjectServiceImpl projectService;

    @Mock
    private ProjectRepository projectRepository;


    private final ProjectDto projectDto = ProjectDto.builder()
                .id(1L)
                .name("Test1")
                .code("test1")
                .description("test1")
                .build();
    private final List<ProjectDto> projectDtoList = List.of(projectDto);


    @Test
    void getAll() {
        when(projectRepository.getAll()).thenReturn(projectDtoList);
        List<ProjectDto> projectDtoListTest = projectService.getAll();
        assertNotNull(projectDtoListTest, "projectDtoListTest = null");
        assertEquals(projectDtoListTest, projectDtoList);
        verify(projectRepository , times(1)).getAll();
    }

    @Test
    void getById() {
        when(projectRepository.getById(1L)).thenReturn(projectDto);
        assertEquals(projectService.getById(1L), projectDto);
        verify(projectRepository , times(1)).getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void create() {
        projectService.create(projectDto);
        verify(projectRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(projectDto)));
    }

    @Test
    void update() {
        projectService.update(projectDto);
        verify(projectRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(projectDto)));
    }

    @Test
    void deleteById() {
        projectService.deleteById(1L);
        verify(projectRepository, times(1))
                .deleteById(ArgumentMatchers.eq(1L));
    }
}