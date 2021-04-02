package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.TechnologicalMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionOrderDto {
    private Long id;
    private String number;
    private LocalDateTime dateTime;
    private Long companyId;
    private String companyName;

    private TechnologicalMapDto techMapDto = new TechnologicalMapDto();

    private BigDecimal volumeOfProduction;
    private Long warehouseId;
    private String warehouseName;
    private LocalDate planDate;
    private Long projectId;
    private String projectName;
    private String comment;

    public ProductionOrderDto(Long id,
                              String number,
                              LocalDateTime dateTime,
                              Long companyId,
                              String companyName,
                              Long techMapDtoId,
                              BigDecimal volumeOfProduction,
                              Long warehouseId,
                              String warehouseName,
                              LocalDate planDate,
                              Long projectId,
                              String projectName,
                              String comment) {
        this.id = id;
        this.number = number;
        this.dateTime = dateTime;
        this.companyId = companyId;
        this.companyName = companyName;
        this.techMapDto.setId(techMapDtoId);
        this.volumeOfProduction = volumeOfProduction;
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.planDate = planDate;
        this.projectId = projectId;
        this.projectName = projectName;
        this.comment = comment;
    }
}
