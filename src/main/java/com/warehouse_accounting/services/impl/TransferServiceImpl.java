package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.TransferDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.TransferRepository;
import com.warehouse_accounting.repositories.WarehouseRepository;
import com.warehouse_accounting.services.interfaces.TransferService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;
    private final WarehouseRepository warehouseRepository;
    private final CompanyRepository companyRepository;

    public TransferServiceImpl(TransferRepository transferRepository,
                               WarehouseRepository warehouseRepository,
                               CompanyRepository companyRepository) {
        this.transferRepository = transferRepository;
        this.warehouseRepository = warehouseRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<TransferDto> getAll() {
        List<TransferDto> transferDtos = transferRepository.getAll();
        for (TransferDto transferDto : transferDtos) {
            transferDto.setWarehouseFrom(
                    warehouseRepository.getById(
                            transferDto.getWarehouseFrom().getId()
                    )
            );
            transferDto.setWarehouseTo(
                    warehouseRepository.getById(
                            transferDto.getWarehouseTo().getId()
                    )
            );
            transferDto.setCompany(
                    companyRepository.getById(
                            transferDto.getCompany().getId()
                    )
            );
        }
        return transferDtos;
    }

    @Override
    public TransferDto getById(Long id) {
        TransferDto transferDto = transferRepository.getById(id);
        transferDto.setWarehouseFrom(
                warehouseRepository.getById(
                        transferDto.getWarehouseFrom().getId()
                )
        );
        transferDto.setWarehouseTo(
                warehouseRepository.getById(
                        transferDto.getWarehouseTo().getId()
                )
        );
        transferDto.setCompany(
                companyRepository.getById(
                        transferDto.getCompany().getId()
                )
        );
        return transferDto;
    }

    @Override
    public void create(TransferDto dto) {
        transferRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void update(TransferDto dto) {
        transferRepository.save(ConverterDto.convertToModel(dto));
    }

    @Override
    public void deleteById(Long id) {
        transferRepository.deleteById(id);
    }
}
