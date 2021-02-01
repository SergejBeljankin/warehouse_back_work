package com.warehouse_accounting.models.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxSystemDto {
    private Long id;
    private String name;
    private String sortNumber;
}
