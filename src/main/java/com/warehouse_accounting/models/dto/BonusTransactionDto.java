package com.warehouse_accounting.models.dto;


import com.warehouse_accounting.models.BonusTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BonusTransactionDto {

    private Long id;

    private LocalDateTime created;

    private BonusTransaction.TransactionType transactionType;

    private Long bonusValue;

    private BonusTransaction.TransactionStatus transactionStatus;

    private LocalDateTime executionDate;

    private String bonusProgram;//TODO create model/dto

    private ContractorDto contragent = new ContractorDto();

    private String comment;

    private EmployeeDto owner = new EmployeeDto();

    public BonusTransactionDto(Long id,
                               LocalDateTime created,
                               BonusTransaction.TransactionType transactionType,
                               Long bonusValue, BonusTransaction.TransactionStatus transactionStatus,
                               LocalDateTime executionDate,
                               String bonusProgram,
                               Long contragentId,
                               String comment,
                               Long ownerId) {
        this.id = id;
        this.created = created;
        this.transactionType = transactionType;
        this.bonusValue = bonusValue;
        this.transactionStatus = transactionStatus;
        this.executionDate = executionDate;
        this.bonusProgram = bonusProgram;
        this.contragent.setId(contragentId);
        this.comment = comment;
        this.owner.setId(ownerId);
    }
}

