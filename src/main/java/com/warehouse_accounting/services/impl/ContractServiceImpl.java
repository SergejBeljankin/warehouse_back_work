package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.Contract;
import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.services.interfaces.ContractService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public List<ContractDto> getAll() {
        List<ContractDto> contractDtos = contractRepository.getAll();
        for (ContractDto contractDto: contractDtos) {
            contractDto.setCompanyDto(ConverterDto.convertToDto(contractRepository.getCompanyById(contractDto.getId())));
            contractDto.setBankAccountDto(ConverterDto.convertToDto(contractRepository.getBankAccountById(contractDto.getId())));
            contractDto.setContractorDto(ConverterDto.convertToDto(contractRepository.getContractorById(contractDto.getId())));
            contractDto.setLegalDetailDto(ConverterDto.convertToDto(contractRepository.getLegalDetailById(contractDto.getId())));
        }
        return contractDtos;
    }

    @Override
    public ContractDto getById(Long id) {
        ContractDto contractDto = contractRepository.getById(id);
        contractDto.setCompanyDto(ConverterDto.convertToDto(contractRepository.getCompanyById(contractDto.getId())));
        contractDto.setBankAccountDto(ConverterDto.convertToDto(contractRepository.getBankAccountById(contractDto.getId())));
        contractDto.setContractorDto(ConverterDto.convertToDto(contractRepository.getContractorById(contractDto.getId())));
        contractDto.setLegalDetailDto(ConverterDto.convertToDto(contractRepository.getLegalDetailById(contractDto.getId())));

        return contractDto;
    }

    @Override
    public void create(ContractDto contractDto) {
        contractRepository.save(ConverterDto.convertToModel(contractDto));
    }

    @Override
    public void update(ContractDto contractDto) {
        contractRepository.save(ConverterDto.convertToModel(contractDto));
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}
