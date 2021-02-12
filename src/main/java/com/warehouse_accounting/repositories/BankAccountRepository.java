package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.BankAccount;
import com.warehouse_accounting.models.dto.BankAccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Query("SELECT new com.warehouse_accounting.models.dto.BankAccountDto(" +
            "ba.id, " +
            "ba.rcbic, " +
            "ba.bank, " +
            "ba.address, " +
            "ba.correspondentAccount, " +
            "ba.account, " +
            "ba.mainAccount, " +
            "ba.sortNumber" +
            ") " +
            "FROM BankAccount ba")
    List<BankAccountDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.BankAccountDto(" +
            "ba.id, " +
            "ba.rcbic, " +
            "ba.bank, " +
            "ba.address, " +
            "ba.correspondentAccount, " +
            "ba.account, " +
            "ba.mainAccount, " +
            "ba.sortNumber" +
            ") " +
            "FROM BankAccount ba where ba.id = :id")
    BankAccountDto getById(@Param("id") Long id);

    @Query("SELECT c.bankAccounts FROM Contractor c WHERE c.id = :id")
    List<BankAccount> getListById(@Param("id") Long id);
}
