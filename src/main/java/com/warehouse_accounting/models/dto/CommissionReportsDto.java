package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class CommissionReportsDto {
    Long id;

    LocalDateTime dateOfCreation;

    Long contractId;
    String contractNumber;

    Long contractorId;
    String contractorName;

    Long companyId;
    String companyName;

    Long projectId;
    String projectName;

    List<ProductDto> productDtos = new ArrayList<>();

    BigDecimal sum = BigDecimal.valueOf(0);

    BigDecimal paid = BigDecimal.valueOf(0);

    Boolean isSent;

    Boolean isPrinted;

    String comment;

    LocalDateTime periodStart;

    LocalDateTime periodEnd;

    BigDecimal reward = BigDecimal.valueOf(0);

    public CommissionReportsDto(
            Long id,
            LocalDateTime dateOfCreation,
            Long contractId,
            String contractNumber,
            Long contractorId,
            String contractorName,
            Long companyId,
            String companyName,
            Long projectId,
            String projectName,
            BigDecimal sum,
            BigDecimal paid,
            Boolean isSent,
            Boolean isPrinted,
            String comment,
            LocalDateTime periodStart,
            LocalDateTime periodEnd,
            BigDecimal reward) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.contractId = contractId;
        this.contractNumber = contractNumber;
        this.contractorId = contractorId;
        this.contractorName = contractorName;
        this.companyId = companyId;
        this.companyName = companyName;
        this.projectId = projectId;
        this.projectName = projectName;
        this.sum = sum;
        this.paid = paid;
        this.isSent = isSent;
        this.isPrinted = isPrinted;
        this.comment = comment;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.reward = reward;
    }
}
