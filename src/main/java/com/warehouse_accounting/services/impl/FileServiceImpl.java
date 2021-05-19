package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.File;
import com.warehouse_accounting.models.dto.FileDto;
import com.warehouse_accounting.repositories.FileRepository;
import com.warehouse_accounting.services.interfaces.FileService;
import com.warehouse_accounting.util.ConverterDto;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class FileServiceImpl implements FileService {
    @Delegate
    FileRepository fileRepository;

    @Override
    public List<FileDto> getAll() {
        return fileRepository.findAll().stream()
                .map(ConverterDto::convertToDto
                ).collect(Collectors.toList());
    }

    @Override
    public FileDto getById(Long id) {
        return fileRepository.findById(id).stream()
                .map(ConverterDto::convertToDto)
                .findAny()
                .orElseThrow();
    }

    @Override
    public File create(FileDto fileDto) {
        return fileRepository.save(ConverterDto.convertToModel(fileDto));
    }

    @Override
    public File update(FileDto fileDto) {
        File file = ConverterDto.convertToModel(fileDto);
        file.setId(fileDto.getId());
        return fileRepository.save(file);
    }

    @Override
    public void delete(Long id) {
         fileRepository.deleteById(id);
    }
}
