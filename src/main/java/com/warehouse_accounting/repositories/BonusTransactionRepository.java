package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.BonusTransaction;
import com.warehouse_accounting.models.dto.BonusTransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BonusTransactionRepository extends JpaRepository<BonusTransaction, Long> {

    @Query("SELECT new com.warehouse_accounting.models.dto.BonusTransactionDto(" +
            "bt.id, " +
            "bt.created, " +
            "bt.transactionType, " +
            "bt.bonusValue, " +
            "bt.transactionStatus, " +
            "bt.executionDate, " +
            "bt.bonusProgram, " +
            "bt.contragent.id, " +
            "bt.comment, " +
            "bt.owner.id) FROM BonusTransaction bt JOIN Employee empl ON (bt.owner.id = empl.id) " +
            "JOIN Contractor cntr ON (bt.contragent.id = cntr.id) ")
    List<BonusTransactionDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.BonusTransactionDto(" +
            "bt.id, " +
            "bt.created, " +
            "bt.transactionType, " +
            "bt.bonusValue, " +
            "bt.transactionStatus, " +
            "bt.executionDate, " +
            "bt.bonusProgram, " +
            "bt.contragent.id, " +
            "bt.comment, " +
            "bt.owner.id) FROM BonusTransaction bt where bt.id=:id")
    BonusTransactionDto getById(@Param("id") Long id);
}
