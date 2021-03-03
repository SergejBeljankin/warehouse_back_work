package com.warehouse_accounting.models.dto;

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
public class TransferDto {

    private Long id;

    private LocalDateTime dateTime;

    private WarehouseDto warehouseFrom = new WarehouseDto();

    private WarehouseDto warehouseTo = new WarehouseDto();

    private CompanyDto company = new CompanyDto();

    private BigDecimal sum = BigDecimal.valueOf(0);

    private boolean transferred;

    private boolean printed;

    private String comment;

    public TransferDto(Long id,
                       LocalDateTime dateTime,
                       Long warehouseFromId,
                       Long warehouseToId,
                       Long companyId,
                       BigDecimal sum,
                       boolean transferred,
                       boolean printed,
                       String comment) {
        this.id = id;
        this.dateTime = dateTime;
        this.warehouseFrom.setId(warehouseFromId);
        this.warehouseTo.setId(warehouseToId);
        this.company.setId(companyId);
        this.sum = sum;
        this.transferred = transferred;
        this.printed = printed;
        this.comment = comment;
    }
}
