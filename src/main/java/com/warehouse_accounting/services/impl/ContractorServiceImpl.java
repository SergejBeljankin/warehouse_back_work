package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.ContractorGetALLDto;
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
    private final BankAccountRepository bankAccountRepository;
    private final LegalDetailRepository legalDetailRepository;

    public ContractorServiceImpl(
            ContractorRepository contractorRepository,
            BankAccountRepository bankAccountRepository,
            LegalDetailRepository legalDetailRepository
    ) {
        this.contractorRepository = contractorRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.legalDetailRepository = legalDetailRepository;
    }

//    @Override
//    public List<ContractorDto> getAll() {
//        List<ContractorDto> contractorDtos = contractorRepository.getAll();
//        for (ContractorDto contractorDto : contractorDtos) {
//            contractorDto.setLegalDetailDto(legalDetailRepository.getById(
//                    contractorDto.getLegalDetailDto().getId()));
//            contractorDto.setBankAccountDtos(bankAccountRepository.getListById(
//                    contractorDto.getId()).stream()
//                    .map(ConverterDto::convertToDto).collect(Collectors.toList()));
//        }
//        return contractorDtos;
//    }
@Override
    public List<ContractorGetALLDto> getAll() {
        return contractorRepository.getAll();
    }

    @Override
    public ContractorDto getById(Long id) {
        ContractorDto contractorDto = contractorRepository.getById(id);
        contractorDto.setLegalDetailDto(legalDetailRepository.getById(
                contractorDto.getLegalDetailDto().getId()));
        contractorDto.setBankAccountDtos(bankAccountRepository.getListById(
                contractorDto.getId()).stream()
                .map(ConverterDto::convertToDto).collect(Collectors.toList()));
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
