package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Contract;
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
            "c.company.id," +
            "c.bankAccount.id," +
            "c.contractor.id," +
            "c.legalDetail.id" +
            ")" +
            "FROM Contract c")
    List<ContractDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ContractDto(" +
            "c.id," +
            "c.number," +
            "c.contractDate," +
            "c.amount," +
            "c.archive," +
            "c.comment," +
            "c.company.id," +
            "c.bankAccount.id," +
            "c.contractor.id," +
            "c.legalDetail.id" +
            ")" +
            "FROM Contract c WHERE c.id = :id")
    ContractDto getById(@Param("id") Long id);

    @Query("SELECT cr.contract FROM CommissionReports cr WHERE cr.id = :id")
    List<Contract> getListContractById(@Param("id") Long id);
}
