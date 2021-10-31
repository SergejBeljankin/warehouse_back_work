package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class ReturnDto {
    Long id;

    LocalDateTime dataTime;

    Long warehouseId;

    Long companyId;

    Long contractorId;

    Long contractId;

    Long projectId;

    List<FileDto> fileDtos = new ArrayList<>();

    List<TaskDto> taskDtos = new ArrayList<>();

    List<ProductDto> productDtos = new ArrayList<>();

    BigDecimal sum = BigDecimal.valueOf(0);

    Boolean isSent;

    Boolean isPrinted;

    String comment;

    public ReturnDto(Long id, LocalDateTime dataTime, Long warehouseId, Long companyId, Long contractorId, Long projectId, BigDecimal sum, Boolean isSent, Boolean isPrinted, String comment) {
        this.id = id;
        this.dataTime = dataTime;
        this.warehouseId = warehouseId;
        this.companyId = companyId;
        this.contractorId = contractorId;
        this.projectId = projectId;
        this.sum = sum;
        this.isSent = isSent;
        this.isPrinted = isPrinted;
        this.comment = comment;
    }
}