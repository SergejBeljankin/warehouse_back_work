package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.repositories.ContractorGroupRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.repositories.TypeOfContractorRepository;
import com.warehouse_accounting.repositories.TypeOfPriceRepository;
import com.warehouse_accounting.services.interfaces.ContractorService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContractorServiceImpl implements ContractorService {

    private final ContractorRepository contractorRepository;
    private final ContractorGroupRepository contractorGroupRepository;
    private final TypeOfContractorRepository typeOfContractorRepository;
    private final TypeOfPriceRepository typeOfPriceRepository;
    private final BankAccountRepository bankAccountRepository;
    private final LegalDetailRepository legalDetailRepository;

    public ContractorServiceImpl(
            ContractorRepository contractorRepository,
            ContractorGroupRepository contractorGroupRepository,
            TypeOfContractorRepository typeOfContractorRepository,
            TypeOfPriceRepository typeOfPriceRepository,
            BankAccountRepository bankAccountRepository,
            LegalDetailRepository legalDetailRepository
    ) {
        this.contractorRepository = contractorRepository;
        this.contractorGroupRepository = contractorGroupRepository;
        this.typeOfContractorRepository = typeOfContractorRepository;
        this.typeOfPriceRepository = typeOfPriceRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.legalDetailRepository = legalDetailRepository;
    }

    @Override
    public List<ContractorDto> getAll() {
        List<ContractorDto> contractorDtos = contractorRepository.getAll();
        for (ContractorDto contractorDto: contractorDtos) {
            contractorDto.setContractorGroupDto(contractorGroupRepository.getById(contractorDto.getContractorGroupDto().getId()));
            contractorDto.setTypeOfContractorDto(typeOfContractorRepository.getById(contractorDto.getTypeOfContractorDto().getId()));
            contractorDto.setTypeOfPriceDto(typeOfPriceRepository.getById(contractorDto.getTypeOfPriceDto().getId()));
            contractorDto.setLegalDetailDto(legalDetailRepository.getById(contractorDto.getLegalDetailDto().getId()));
            contractorDto.setBankAccountDtos(bankAccountRepository.getListById(contractorDto.getId()).stream().map(bankAccount -> ConverterDto.convertToDto(bankAccount)).collect(Collectors.toList()));
        }
        return contractorDtos;
    }

    @Override
    public ContractorDto getById(Long id) {
        ContractorDto contractorDto = contractorRepository.getById(id);
        contractorDto.setContractorGroupDto(contractorGroupRepository.getById(contractorDto.getContractorGroupDto().getId()));
        contractorDto.setTypeOfContractorDto(typeOfContractorRepository.getById(contractorDto.getTypeOfContractorDto().getId()));
        contractorDto.setTypeOfPriceDto(typeOfPriceRepository.getById(contractorDto.getTypeOfPriceDto().getId()));
        contractorDto.setLegalDetailDto(legalDetailRepository.getById(contractorDto.getLegalDetailDto().getId()));
        contractorDto.setBankAccountDtos(bankAccountRepository.getListById(contractorDto.getId()).stream().map(bankAccount -> ConverterDto.convertToDto(bankAccount)).collect(Collectors.toList()));
        return contractorDto;
    }

    @Override
    public void create(ContractorDto contractorDto) {
        contractorRepository.save(ConverterDto.convertToModel(contractorDto));
    }

    @Override
    public void update(ContractorDto contractorDto) {
        contractorRepository.save(ConverterDto.convertToModel(contractorDto));
    }

    @Override
    public void deleteById(Long id) {
        contractorRepository.deleteById(id);
    }
}
