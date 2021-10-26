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
public class MovingFieldsDto {


    LocalDateTime dateOfCreation;

    Long contractId;

    Long contractorId;

    Long companyId;

    List<ProductDto> productDtos = new ArrayList<>();

    BigDecimal sum = BigDecimal.valueOf(0);

    BigDecimal paid = BigDecimal.valueOf(0);

    Boolean isSent;

    Boolean isPrinted;

    String comment;

    public MovingFieldsDto(
            LocalDateTime dateOfCreation,
            Long contractId,
            Long contractorId,
            Long companyId,
            BigDecimal sum,
            BigDecimal paid,
            Boolean isSent,
            Boolean isPrinted,
            String comment) {
        this.dateOfCreation = dateOfCreation;
        this.contractId = contractId;
        this.contractorId = contractorId;
        this.companyId = companyId;
        this.sum = sum;
        this.paid = paid;
        this.isSent = isSent;
        this.isPrinted = isPrinted;
        this.comment = comment;
    }
}
