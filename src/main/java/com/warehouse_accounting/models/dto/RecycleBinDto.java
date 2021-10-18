package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecycleBinDto {

    private Long id;
    private String documentType;
    private String number;
    private LocalDate date;
    private BigDecimal sum;
    private String warehouseTo;
    private String warehouseFrom;
    private String companyName;
    private String contractorName;
    private String status;
    private String shipped;
    private String printed;
    private String comment;
}
