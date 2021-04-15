package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.TypeOfAdjustment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdjustmentDto {

    private Long id;

    private String number;

    private LocalDateTime dateTimeAdjustment;

    private Long companyId;
    private String companyName;

    private Long contractorId;
    private String contractorName;

    private TypeOfAdjustment type;

    private BigDecimal currentBalance = BigDecimal.valueOf(0);

    private BigDecimal totalBalance = BigDecimal.valueOf(0);

    private BigDecimal adjustmentAmount = BigDecimal.valueOf(0);

    private String comment;

    private LocalDateTime whenСhanged;
}
