package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.Position;
import com.warehouse_accounting.models.dto.PositionDto;
import com.warehouse_accounting.repositories.PositionRepository;
import com.warehouse_accounting.services.interfaces.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<PositionDto> getAll() {
        return positionRepository.getAll();
    }

    @Override
    public PositionDto getById(Long id) {
        return positionRepository.getById(id);
    }

    @Override
    public void create(PositionDto dto) {
        positionRepository.save(convertToModel(dto));
    }

    @Override
    public void update(PositionDto dto) {
        positionRepository.save(convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }

    //TODO перенести в класс конвертера, когда появится
    public static Position convertToModel(PositionDto positionDto) {
        return Position.builder()
                .id(positionDto.getId())
                .name(positionDto.getName())
                .sortNumber(positionDto.getSortNumber())
                .build();
    }

    //TODO перенести в класс конвертера, когда появится
    public static PositionDto convertToDto(Position position) {
        return PositionDto.builder()
                .id(position.getId())
                .name(position.getName())
                .sortNumber(position.getSortNumber())
                .build();
    }
}
