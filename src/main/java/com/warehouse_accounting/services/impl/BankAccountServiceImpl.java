package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.BankAccountDto;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.services.interfaces.BankAccountService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public List<BankAccountDto> getAll() {
        return bankAccountRepository.getAll();
    }

    @Override
    public BankAccountDto getById(Long id) {
        return bankAccountRepository.getById(id);
    }

    @Override
    public void create(BankAccountDto bankAccountDto) {
        bankAccountRepository.save(ConverterDto.convertToModel(bankAccountDto));
    }

    @Override
    public void update(BankAccountDto bankAccountDto) {
        bankAccountRepository.save(ConverterDto.convertToModel(bankAccountDto));
    }

    @Override
    public void deleteById(Long id) {
        bankAccountRepository.deleteById(id);
    }


}
