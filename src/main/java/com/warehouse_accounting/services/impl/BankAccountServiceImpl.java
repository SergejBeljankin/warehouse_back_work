package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.BankAccount;
import com.warehouse_accounting.models.dto.BankAccountDto;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.services.interfaces.BankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
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
        bankAccountRepository.save(convertToModel(bankAccountDto));
    }

    @Override
    public void update(BankAccountDto bankAccountDto) {
        bankAccountRepository.save(convertToModel(bankAccountDto));
    }

    @Override
    public void deleteById(Long id) {
        bankAccountRepository.deleteById(id);
    }

    private BankAccount convertToModel(BankAccountDto bankAccountDto) {
        return BankAccount.builder()
                .id(bankAccountDto.getId())
                .rcbic(bankAccountDto.getRcbic())
                .bank(bankAccountDto.getBank())
                .address(bankAccountDto.getAddress())
                .correspondentAccount(bankAccountDto.getCorrespondentAccount())
                .account(bankAccountDto.getAccount())
                .mainAccount(bankAccountDto.getMainAccount())
                .sortNumber(bankAccountDto.getSortNumber())
                .build();
    }

    private BankAccountDto convertToDto(BankAccount bankAccount) {
        return BankAccountDto.builder()
                .id(bankAccount.getId())
                .rcbic(bankAccount.getRcbic())
                .bank(bankAccount.getBank())
                .address(bankAccount.getAddress())
                .correspondentAccount(bankAccount.getCorrespondentAccount())
                .account(bankAccount.getAccount())
                .mainAccount(bankAccount.getMainAccount())
                .sortNumber(bankAccount.getSortNumber())
                .build();
    }
}
