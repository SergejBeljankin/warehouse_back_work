package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseDto {
    private Long id;
    private String name;
    private String sortNumber;
    private String address;
    private String commentToAddress;
    private String comment;
}
