package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class CommissionReportsDto {
    Long id;

    LocalDateTime dateOfCreation;

    ContractDto contractDto = new ContractDto();

    ContractorDto contractorDto = new ContractorDto();

    CompanyDto companyDto = new CompanyDto();

    ProjectDto projectDto = new ProjectDto();

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
            Long contractorId,
            Long companyId,
            Long projectId,
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
        this.contractDto.setId(contractId);
        this.contractorDto.setId(contractorId);
        this.companyDto.setId(companyId);
        this.projectDto.setId(projectId);
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
