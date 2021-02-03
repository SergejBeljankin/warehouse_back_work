package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductGroupDto {
    private Long id;
    private String name;
    private String sortNumber;
    private ProductGroupDto productGroup;
}
