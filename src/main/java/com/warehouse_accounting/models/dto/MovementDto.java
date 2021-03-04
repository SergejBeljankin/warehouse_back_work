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
public class MovementDto {

    private Long id;

    private LocalDateTime dateTime;

    private WarehouseDto warehouseFrom = new WarehouseDto();

    private WarehouseDto warehouseTo = new WarehouseDto();

    private CompanyDto company = new CompanyDto();

    private BigDecimal sum = BigDecimal.valueOf(0);

    private boolean moved;

    private boolean printed;

    private String comment;

    public MovementDto(Long id,
                       LocalDateTime dateTime,
                       Long warehouseFromId,
                       Long warehouseToId,
                       Long companyId,
                       BigDecimal sum,
                       boolean moved,
                       boolean printed,
                       String comment) {
        this.id = id;
        this.dateTime = dateTime;
        this.warehouseFrom.setId(warehouseFromId);
        this.warehouseTo.setId(warehouseToId);
        this.company.setId(companyId);
        this.sum = sum;
        this.moved = moved;
        this.printed = printed;
        this.comment = comment;
    }
}
