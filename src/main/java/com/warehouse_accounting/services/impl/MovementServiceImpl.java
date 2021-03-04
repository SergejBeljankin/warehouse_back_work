package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.MovementDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.MovementRepository;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.MovementService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;
    private final WarehouseRepository warehouseRepository;
    private final CompanyRepository companyRepository;

    public MovementServiceImpl(MovementRepository movementRepository,
                               WarehouseRepository warehouseRepository,
                               CompanyRepository companyRepository) {
        this.movementRepository = movementRepository;
        this.warehouseRepository = warehouseRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<MovementDto> getAll() {
        List<MovementDto> movementDtos = movementRepository.getAll();
        for (MovementDto movementDto : movementDtos) {
            movementDto.setWarehouseFrom(
                    warehouseRepository.getById(
                            movementDto.getWarehouseFrom().getId()
                    )
            );
            movementDto.setWarehouseTo(
                    warehouseRepository.getById(
                            movementDto.getWarehouseTo().getId()
                    )
            );
            movementDto.setCompany(
                    companyRepository.getById(
                            movementDto.getCompany().getId()
                    )
            );
        }
        return movementDtos;
    }

    @Override
    public MovementDto getById(Long id) {
        MovementDto movementDto = movementRepository.getById(id);
        movementDto.setWarehouseFrom(
                warehouseRepository.getById(
                        movementDto.getWarehouseFrom().getId()
                )
        );
        movementDto.setWarehouseTo(
                warehouseRepository.getById(
                        movementDto.getWarehouseTo().getId()
                )
        );
        movementDto.setCompany(
                companyRepository.getById(
                        movementDto.getCompany().getId()
                )
        );
        return movementDto;
    }

    @Override
    public void create(MovementDto dto) {
        movementRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(MovementDto dto) {
        movementRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        movementRepository.deleteById(id);
    }
}
