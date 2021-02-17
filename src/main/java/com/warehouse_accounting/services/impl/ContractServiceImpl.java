package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ContractService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final CompanyRepository companyRepository;
    private final BankAccountRepository bankAccountRepository;
    private final ContractorRepository contractorRepository;
    private final LegalDetailRepository legalDetailRepository;
    private final CheckEntityService checkEntityService;

    public ContractServiceImpl(
            ContractRepository contractRepository,
            CompanyRepository companyRepository,
            BankAccountRepository bankAccountRepository,
            ContractorRepository contractorRepository,
            LegalDetailRepository legalDetailRepository,
            CheckEntityService checkEntityService
            ) {
        this.contractRepository = contractRepository;
        this.companyRepository = companyRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.contractorRepository = contractorRepository;
        this.legalDetailRepository = legalDetailRepository;
        this.checkEntityService = checkEntityService;
    }

    @Override
    public List<ContractDto> getAll() {
        List<ContractDto> contractDtos = contractRepository.getAll();
        for (ContractDto contractDto: contractDtos) {
            contractDto.setCompanyDto(companyRepository.getById(contractDto.getCompanyDto().getId()));
            contractDto.setBankAccountDto(bankAccountRepository.getById(contractDto.getBankAccountDto().getId()));
            contractDto.setContractorDto(contractorRepository.getById(contractDto.getContractorDto().getId()));
            contractDto.setLegalDetailDto(legalDetailRepository.getById(contractDto.getLegalDetailDto().getId()));
        }
        return contractDtos;
    }

    @Override
    public ContractDto getById(Long id) {
        checkEntityService.checkExistContractById(id);
        ContractDto contractDto = contractRepository.getById(id);
        contractDto.setCompanyDto(companyRepository.getById(contractDto.getCompanyDto().getId()));
        contractDto.setBankAccountDto(bankAccountRepository.getById(contractDto.getBankAccountDto().getId()));
        contractDto.setContractorDto(contractorRepository.getById(contractDto.getContractorDto().getId()));
        contractDto.setLegalDetailDto(legalDetailRepository.getById(contractDto.getLegalDetailDto().getId()));

        return contractDto;
    }

    @Override
    public void create(ContractDto contractDto) {
        contractRepository.save(ConverterDto.convertToModel(contractDto));
    }

    @Override
    public void update(ContractDto contractDto) {
        checkEntityService.checkExistContractById(contractDto.getId());
        contractRepository.save(ConverterDto.convertToModel(contractDto));
    }

    @Override
    public void deleteById(Long id) {
        checkEntityService.checkExistContractById(id);
        contractRepository.deleteById(id);
    }
}
