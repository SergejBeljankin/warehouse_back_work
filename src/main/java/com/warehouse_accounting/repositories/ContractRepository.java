package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.BankAccount;
import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.Contract;
import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.dto.ContractDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ContractDto(" +
            "c.id," +
            "c.number," +
            "c.contractDate," +
            "c.amount," +
            "c.archive," +
            "c.comment," +
            ")" +
            "FROM Contract u")
    List<ContractDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ContractDto(" +
            "c.id," +
            "c.number," +
            "c.contractDate," +
            "c.amount," +
            "c.archive," +
            "c.comment," +
            ")" +
            "FROM Contract u WHERE c.id = :id")
    ContractDto getById(@Param("id") Long id);

    @Query("SELECT c.company FROM Contract c WHERE c.id = :id")
    Company getCompanyById(@Param("id") Long id);

    @Query("SELECT c.bankAccount FROM Contract c WHERE c.id = :id")
    BankAccount getBankAccountById(@Param("id") Long id);

    @Query("SELECT c.contractor FROM Contract c WHERE c.id = :id")
    Contractor getContractorById(@Param("id") Long id);

    @Query("SELECT c.legalDetail FROM Contract c WHERE c.id = :id")
    LegalDetail getLegalDetailById(@Param("id") Long id);
}
