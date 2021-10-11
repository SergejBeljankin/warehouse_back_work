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
@AllArgsConstructor
@NoArgsConstructor
public class BonusTransactionDto {

    private Long id;

    private LocalDateTime created;

    private BonusTransaction.TransactionType transactionType;

    private Long bonusValue;

    private BonusTransaction.TransactionStatus transactionStatus;

    private LocalDateTime executionDate;

    private String bonusProgram;//TODO create model/dto

    private String contragent;//TODO create model/dto

    private String comment;

    private EmployeeDto owner = new EmployeeDto();


}
