package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.RecycleBin;
import com.warehouse_accounting.models.dto.RecycleBinDto;
import com.warehouse_accounting.repositories.RecycleBinRepository;
import com.warehouse_accounting.services.interfaces.RecycleBinService;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class RecycleBinServiceServiceImpl implements RecycleBinService {
    @Delegate
    RecycleBinRepository recycleBinRepository;

    @Override
    public List<RecycleBinDto> getAll() {
        return recycleBinRepository.findAll().stream()
                .map(recycleBin -> RecycleBinDto.builder()
                        .id(recycleBin.getId())
                        .name(recycleBin.getName())
                        .createdDate(recycleBin.getCreatedDate())
                        .document(recycleBin.getDocument())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public RecycleBinDto getById(UUID id) {
        return recycleBinRepository.findById(id)
                .map(recycleBin -> RecycleBinDto.builder()
                        .id(recycleBin.getId())
                        .name(recycleBin.getName())
                        .createdDate(recycleBin.getCreatedDate())
                        .document(recycleBin.getDocument())
                        .build()
                ).orElseThrow();
    }

    @Override
    public void create(RecycleBinDto recycleBinDto) {
        recycleBinRepository.save(new RecycleBin(recycleBinDto.getName(),
                recycleBinDto.getCreatedDate(),
                recycleBinDto.getDocument()
        ));
    }

    @Override
    public void update(RecycleBinDto recycleBinDto) {
        RecycleBin recycleBin = new RecycleBin(recycleBinDto.getName(),
                recycleBinDto.getCreatedDate(),
                recycleBinDto.getDocument()
        );
        recycleBin.setId(recycleBinDto.getId());
        recycleBinRepository.save(recycleBin);
    }
}
